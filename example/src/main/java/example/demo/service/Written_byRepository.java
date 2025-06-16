package example.demo.service;

import example.demo.domain.BookEntity;
import example.demo.domain.Written_byEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Written_byRepository extends JpaRepository<Written_byEntity, Integer> {
    @Query(value = "select distinct name from written_by", nativeQuery = true)
    List<String> findWriterNames();

    @Query(value = "select distinct address from written_by where name = :name", nativeQuery = true)
    String findAddressByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "insert into written_by values (:name, :address, :isbn)", nativeQuery = true)
    void insertWriter(@Param("name") String name,
                         @Param("address") String address,
                         @Param("isbn") int isbn);
}

