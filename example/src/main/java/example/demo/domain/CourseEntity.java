package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="COURSE")
@Table(name="COURSE")
@Getter
@Setter
public class CourseEntity {
    @Id
    @Column(name = "CNO")
    private String cno;

    @Column(name = "CNAME")
    private String cname;

    @Column(name = "CREDIT")
    private int credit;

    @Column(name = "SESSIONS")
    private int sessions;
}