package example.demo.service;

import example.demo.domain.BookEntity;
import example.demo.domain.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Integer> {
    @Query(
            value = "select * from publisher",
            nativeQuery = true
    )
    List<Object[]> findPublisher();

}
