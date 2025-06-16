package example.demo.service;

import example.demo.domain.ProfessorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
    @Modifying
    @Transactional
    @Query(
            value = "SELECT * FROM PROFESSOR",
            nativeQuery = true
    )
    void saveProfessor (
            @Param("pno") int pno,
            @Param("pname") String panme,
            @Param("pmajor") String pmajor,
            @Param("pedpt") String pdept
    );

    List<ProfessorEntity> findAllByOrderByPnoAsc();

    @Query(
            value = "SELECT COUNT(*) FROM PROFESSOR",
            nativeQuery = true
    )
    long countProfessors();
}
