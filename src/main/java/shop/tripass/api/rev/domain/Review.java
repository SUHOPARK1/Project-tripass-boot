package shop.tripass.api.rev.domain;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import shop.tripass.api.pce.domain.Place;
import shop.tripass.api.rcm.domain.Recom;
import shop.tripass.api.usr.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity @Getter @Table(name = "review")
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rev_num")private long revNum;
    @Column(name="rev_name")private String revName;
    @Column(name="rev_star")private String revStar;
    @Column(name="rev_content")private String revContent;
    @Column(name="rev_date")private String revDate;

    @ManyToOne
    @JoinColumn(name="num") private User user;

    @ManyToOne
    @JoinColumn(name="contentid") private Place place;

    @Builder

    public Review(long revNum, String revName, String revStar, String revContent,
                  String revDate, User user, Place place) {
        super();
        this.revNum = revNum;
        this.revName = revName;
        this.revStar = revStar;
        this.revContent = revContent;
        this.revDate = revDate;
        this.user = user;
        this.place = place;
    }
}