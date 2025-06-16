package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="PROFESSOR")
@Table(name="PROFESSOR")
@Getter
@Setter
public class ProfessorEntity {
    @Id
    @Column(name = "PNO")
    private int pno;

    @Column(name = "PNAME")
    private String pname;

    @Column(name = "PMAJOR")
    private String pmajor;

    @Column(name = "PDEPT")
    private String pdept;
}
