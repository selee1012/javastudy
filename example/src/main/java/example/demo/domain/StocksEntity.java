package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="STOCKS")
@Table(name="STOCKS")
@Getter
@Setter
public class StocksEntity {
    @Id
    @Column(name = "ISBN")
    private int isbn;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NUM")
    private int num;
}
