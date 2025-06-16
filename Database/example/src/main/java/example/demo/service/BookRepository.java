package example.demo.service;

import example.demo.domain.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    @Query (
            value = "SELECT * FROM BOOK WHERE YEAR > 2015",
            nativeQuery = true
    )
    List<BookEntity> findAllByYear();

    @Modifying
    @Transactional
    @Query(value = "insert into book values (:isbn, :title, :year, :price)", nativeQuery = true)
    void insertBook(@Param("isbn") int isbn, @Param("title") String title, @Param("year") int year, @Param("price") int price);

    @Query(value = "select title, sum(num) " +
            "from book natural join written_by natural join stocks " +
            "where name = ?1 " +
            "group by title", nativeQuery = true)
    List<Object[]> findWriteBookData(String name);

    @Query(value = "select title, price, sum(num) " +
            "from book natural join published_by natural join stocks " +
            "where name = ?1 " +
            "group by title, price", nativeQuery = true)
    List<Object[]> findPublisherBookData(String name);

    @Query(value = "select round(avg(price), 2) from book", nativeQuery = true)
    float findAllBookPriceAvg();

    @Query(value = "select year, round(avg(price), 2) " +
            "from book " +
            "group by year " +
            "order by year", nativeQuery = true)
    List<Object[]> findYearBookPriceAvg();

    @Query(value = "select name, count(isbn), min(price), round(avg(price), 2), max(price) " +
            "from book natural join written_by " +
            "group by name", nativeQuery = true )
    List<Object[]> findWritterBookData();

    @Query(value = "select isbn, title, year, price, sum(num) " +
            "from book natural join stocks " +
            "where num>=?1 " +
            "group by isbn, title, year, price", nativeQuery = true )
    List<Object[]> findManyNumBook(int n);

    @Modifying
    @Transactional
    @Query( value = "update book set price = price * 0.9 " +
            "where isbn in (select isbn from stocks where num>=?)", nativeQuery = true)
    void updateBook(@Param("n") int n);
}
