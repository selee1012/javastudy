package example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="LECTURE")
@Table(name="LECTURE")
@Getter
@Setter
public class LectureEntity {
    @Id
    @Column(name = "CNO")
    private String cno;

    @Column(name = "PNO")
    private int pno;

    @Column(name = "LEC_TIME")
    private String lec_time;

    @Column(name = "ROOM")
    private String room;
}
