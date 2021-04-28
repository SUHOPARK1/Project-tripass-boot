package shop.tripass.api.crs.domain;

import shop.tripass.api.rcm.domain.Recom;
import shop.tripass.api.usr.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="crs_num") private long crsNum;
    @Column(name="crs_name") private String crsName;
    @ElementCollection private List<Long> places;


    @ManyToOne
    @JoinColumn(name="num") private User user;
    @ManyToOne
    @JoinColumn(name="rcm_num")private Recom recom;

    @Builder
    public Course(String crsName,List<Long> places,User user){
        this.crsName=crsName;
        this.places=places;
        this.user=user;
    }
}