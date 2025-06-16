package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="BASKET_OF")
@Table(name="BASKET_OF")
@Getter
@Setter
public class Basket_ofEntity {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "basketid")
    private String basketid;
}
