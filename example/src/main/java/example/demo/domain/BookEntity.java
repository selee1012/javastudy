package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="BOOK")
@Table(name="BOOK")
@Getter
@Setter
public class BookEntity {
    @Id
    @Column(name = "ISBN")
    private int isbn;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "PRICE")
    private int price;
}
