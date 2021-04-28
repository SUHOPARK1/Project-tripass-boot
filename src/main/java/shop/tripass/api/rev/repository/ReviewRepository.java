package shop.tripass.api.rev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.tripass.api.rev.domain.Review;
import shop.tripass.api.rev.domain.ReviewDto;

interface ReviewCustomRepository{
    public List<Review> findByRevName(String revName);
    public List<ReviewDto> findList();
    public List<ReviewDto> findRevByPceConentId(long contentid);
    public List<ReviewDto> delete();
}

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {

}