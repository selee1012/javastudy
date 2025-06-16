package example.demo.service;

import example.demo.domain.BookEntity;
import example.demo.domain.StocksEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<StocksEntity, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into stocks values (:isbn, :code, :num)", nativeQuery = true)
    void insertStocks(@Param("isbn") int isbn, @Param("code") String code, @Param("num") int num);
}
