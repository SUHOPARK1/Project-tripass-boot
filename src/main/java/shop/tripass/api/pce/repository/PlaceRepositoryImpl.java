package shop.tripass.api.pce.repository;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import static shop.tripass.api.pce.domain.QPlace.place;
import static shop.tripass.api.rev.domain.QReview.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import shop.tripass.api.pce.domain.Place;
import shop.tripass.api.pce.domain.PlaceDto;



public class PlaceRepositoryImpl extends QuerydslRepositorySupport implements IPlaceRepository{

    private final JPAQueryFactory qf;
    private final EntityManager em;

    public PlaceRepositoryImpl(JPAQueryFactory qf, EntityManager em) {
        super(Place.class);
        this.qf = qf;
        this.em = em;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Place> findByTitle(String title) {
        return em.createQuery("select p from Place p where p.title like : title").setParameter("title", title).getResultList();
    }
    @Override
    public List<PlaceDto> findByContentid(long contentid) {
        List<PlaceDto> places = qf.from(place)
                .select(Projections.constructor
                        (PlaceDto.class, place.contentid,
                                place.firstimage,
                                place.title,
                                place.overview))
                .where(place.contentid.eq(contentid))
                .fetch();
        return places;
    }
    @Override
    public List<PlaceDto> findByList() {
        List<Tuple> res = qf.select(place.title, place.firstimage,
                place.contentid).from(place).fetch();
        List<PlaceDto> list = new ArrayList<>();
        for(int i=0;i<res.size();i++) {
            PlaceDto p = new PlaceDto();
            p.setTitle(res.get(i).get(place.title));
            p.setFirstimage(res.get(i).get(place.firstimage));
            p.setContentid(res.get(i).get(place.contentid));
            list.add(p);
        }
        return list;
    }

}