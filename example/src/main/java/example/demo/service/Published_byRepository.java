package example.demo.service;

import example.demo.domain.BookEntity;
import example.demo.domain.Published_byEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Published_byRepository extends JpaRepository<Published_byEntity, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into published_by values (:name, :isbn)", nativeQuery = true)
    void insertPublisher(@Param("name") String name, @Param("isbn") int isbn);
}
