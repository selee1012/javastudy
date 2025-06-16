package example.demo.service;

import example.demo.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    @Query(
            value = "SELECT * FROM CUSTOMER",
            nativeQuery = true
    )
    List<Object[]> findCustomer();

    @Query(value = "select b.title, p.name, w.name, w.address  " +
            "from customer c join basket_of bo on c.email = bo.email " +
            "    join contains con on bo.basketid = con.basketid " +
            "    join book b on con.isbn = b.isbn " +
            "    join written_by w on b.isbn = w.isbn " +
            "    join published_by p on b.isbn = p.isbn " +
            "where c.email = ?1", nativeQuery = true)
    List<Object[]> findCustomerBookData(String customerName);
}
