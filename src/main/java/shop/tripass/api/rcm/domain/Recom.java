package shop.tripass.api.rcm.domain;

import shop.tripass.api.crs.domain.Course;
import shop.tripass.api.pce.domain.Place;
import shop.tripass.api.svy.domain.Survey;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Recom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rcm_num") private long rcmNum;


    @ManyToOne
    @JoinColumn(name="svy_num") private Survey survey;

    @ManyToOne
    @JoinColumn(name="pce_num") private Place place;


    @OneToMany(mappedBy = "recom")
    private List<Course> courseList = new ArrayList<>();

}
