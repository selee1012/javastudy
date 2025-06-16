package example.demo.service;

import example.demo.domain.LectureEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<LectureEntity, Integer> {
    @Modifying
    @Transactional
    @Query(
            value = "SELECT * FROM LECTURE",
            nativeQuery = true
    )
    void saveLecture (
            @Param("cno") String cno,
            @Param("pno") int pno,
            @Param("lec_time") String lec_time,
            @Param("room") String room
    );

    List<LectureEntity> findAllByOrderByCnoAscPnoAsc();

    @Query(
            value = "SELECT COUNT(*) FROM LECTURE",
            nativeQuery = true
    )
    long countLectures();

    @Query(value = "select pdept, count(cno) " +
            "from lecture natural join professor " +
            "group by pdept", nativeQuery = true)
    List<Object[]> lectureCountData();
}
