package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="STUDENT")
@Table(name="STUDENT")
@Getter
@Setter
public class StudentEntity {
    @Id
    @Column(name = "SNO")
    private int sno;

    @Column(name = "PNO")
    private int pno;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "DEPT")
    private String dept;

}
