package shop.tripass.api.rev.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import shop.tripass.api.cmm.service.AbstractService;
import shop.tripass.api.pce.repository.PlaceRepository;
import shop.tripass.api.rev.domain.Review;
import shop.tripass.api.rev.domain.ReviewDto;
import shop.tripass.api.rev.repository.ReviewRepository;
import shop.tripass.api.usr.repository.UserRepository;
import shop.tripass.api.usr.repository.UserRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repo;

    private final PlaceRepository pceRepo;

    private final UserRepository usrRepo;

    public long save(ReviewDto r) {
        System.out.println(r);
        return (repo.save(toEntity(r)) != null) ? 1 : 0; }

    public long delete(Review t) {repo.delete(t); return (getOne(t.getRevNum()) == null) ? 1 : 0;}

    public long count() {return (long)repo.count();}

    public Review getOne(long id) {return repo.getOne(id);}

    public Optional<Review> findById(long id) {return repo.findById(id);}

    public boolean existsById(long id) {return repo.existsById(id);}

    public List<Review> findAll() { return repo.findAll();}

    public List<ReviewDto> findList() {return repo.findList();}

    public List<ReviewDto> findRevByPceConentId(long contentid) {
        return repo.findRevByPceConentId(contentid); }

    public Review toEntity(ReviewDto r) {
        return Review.builder()
                .revNum(r.getRevNum())
                .revName(r.getRevName())
                .revStar(r.getRevStar())
                .revContent(r.getRevContent())
                .revDate(r.getRevDate())
                .place(pceRepo.getOne(r.getContentid()))
                .user(usrRepo.getOne(r.getNum()))
                .build();
    }
}