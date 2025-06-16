package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="ENROLL")
@Table(name="ENROLL")
@Getter
@Setter
public class EnrollEntity {
    @Id
    @Column(name = "SNO")
    private int sno;

    @Column(name = "CNO")
    private String cno;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "EXAM")
    private int exam;
}
