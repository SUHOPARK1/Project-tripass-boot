package shop.tripass.api.usr.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import shop.tripass.api.crs.domain.Course;
import shop.tripass.api.rev.domain.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;
    private String role;
    private String provider;
    @Column(name = "provider_id")
    private String providerId;
    private String username;
    private String email;
    private String age;
    private String gender;
    private String password;

    @CreationTimestamp
    private Timestamp createDate;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Course> courseList = new ArrayList<>();

    @Builder
    public User(String role, String provider, String providerId, String username, String email, String age, String gender) {
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.username = username;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }
}
