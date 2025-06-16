package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="PUBLISHED_BY")
@Table(name="PUBLISHED_BY")
@Getter
@Setter
public class Published_byEntity {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "ISBN")
    private int isbn;
}
