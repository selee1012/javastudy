package example.demo.service;

import example.demo.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    @Query (
            value = "SELECT * FROM STUDENT",
            nativeQuery = true
    )
    void saveStudent (
            @Param("sno") int sno,
            @Param("pno") int pno,
            @Param("sname") String sname,
            @Param("year") int year,
            @Param("dept") String dept
    );
    List<StudentEntity> findAllByOrderBySnoAsc();

    @Query(
            value = "SELECT COUNT(*) FROM STUDENT",
            nativeQuery = true
    )
    long countStudents();

    @Query(value = "select cname, grade, exam " +
            "from student natural join enroll natural join course " +
            "where sname = ?1", nativeQuery = true)
    List<Object[]> findStudentCourseGradeData(String sname);

    @Query(value = "select sname, sno, cno " +
            "from student natural join enroll natural join course " +
            "where (exam < 60 and grade != 'F') " +
            "    or (exam >= 60 and exam < 70 and grade != 'D') " +
            "    or (exam >= 70 and exam < 80 and grade != 'C') " +
            "    or (exam >= 80 and exam < 90 and grade != 'B') " +
            "    or (exam >= 90 and grade != 'A')",
            nativeQuery = true)
    List<Object[]> findWrongGradeData();

    @Query(value = "select * " +
            "from student join enroll e using (sno) " +
            "WHERE exam = ( " +
            "    SELECT MAX(exam) " +
            "    FROM enroll e2 " +
            "    where e2.cno = e.cno " +
            ") " +
            "OR exam = ( " +
            "    SELECT MIN(exam) " +
            "    FROM enroll e2 " +
            "    where e2.cno = e.cno " +
            ")" +
            "order by e.cno, exam desc",nativeQuery = true)
    List<Object[]> findMinMaxScoreData();

    @Query(value = "select sno, sname, sum(credit), avg(exam) " +
            "from student natural join enroll natural join course " +
            "group by sno, sname order by sno", nativeQuery = true)
    List<Object[]> findSumStudentData();

    @Query(value = "select dept, year, count(sno) " +
            "from student " +
            "group by dept, year " +
            "order by dept, year", nativeQuery = true)
    List<Object[]> sumStudentData();
}
