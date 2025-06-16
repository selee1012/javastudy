package example.demo.service;

import example.demo.domain.CourseEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    @Modifying
    @Transactional
    @Query(
            value = "SELECT * FROM COURSE",
            nativeQuery = true
    )
    void saveCourse (
            @Param("cno") String cno,
            @Param("cname") String cname,
            @Param("credit") int credit,
            @Param("sessions") int sessions
    );

    List<CourseEntity> findAllByOrderByCnoAsc();

    @Query(
            value = "SELECT COUNT(*) FROM COURSE",
            nativeQuery = true
    )
    long countCourses();
}
