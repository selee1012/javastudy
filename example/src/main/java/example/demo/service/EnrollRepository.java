package example.demo.service;

import example.demo.domain.EnrollEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, Integer> {
    @Modifying
    @Transactional
    @Query(
            value = "SELECT * FROM ENROLL",
            nativeQuery = true
    )
    void saveEnroll (
            @Param("sno") int sno,
            @Param("cno") String cno,
            @Param("grade") String grade,
            @Param("exam") int exam
    );

    List<EnrollEntity> findAllByOrderBySnoAscCnoAsc();

    @Query(
            value = "SELECT COUNT(*) FROM ENROLL",
            nativeQuery = true
    )
    long countEnrolls();

    @Modifying
    @Transactional
    @Query(value = "update enroll " +
            "set grade = case " +
            "when exam >= 90 and grade != 'A' then 'A' " +
            "when exam >= 80 and exam <90 and grade != 'B' then 'B' " +
            "when exam >= 70 and exam <80 and grade != 'C' then 'C' " +
            "when exam >= 60 and exam <70 and grade != 'D' then 'D' " +
            "when exam <60 and grade != 'F' then 'F' " +
            "end " +
            "where sno = ?1 AND cno = ?2", nativeQuery = true)
    void updateEnrollGrade(int sno, String cno);

    @Query(value = "select * " +
            "from " +
            "(select cname, avg(exam) " +
            "from enroll natural join course " +
            "group by cname) " +
            "natural join " +
            "(select cname, grade, count(sno) " +
            "from enroll natural join course " +
            "group by cname, grade) " +
            "order by cname, grade", nativeQuery = true)
    List<Object[]> courseAvgExamGradeData();
}
