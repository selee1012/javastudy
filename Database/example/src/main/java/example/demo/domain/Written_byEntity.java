package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="WRITTEN_BY")
@Table(name="WRITTEN_BY")
@Getter
@Setter
public class Written_byEntity {
    @Id
    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ISBN")
    private int isbn;
}
