package shop.tripass.api.rcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.tripass.api.rcm.domain.Recom;

@Repository
public interface RecomRepository extends JpaRepository<Recom,Long> {
}