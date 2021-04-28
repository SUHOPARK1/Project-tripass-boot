package shop.tripass.api.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.tripass.api.crs.domain.Course;
import shop.tripass.api.usr.domain.User;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByUser(User user);
}
