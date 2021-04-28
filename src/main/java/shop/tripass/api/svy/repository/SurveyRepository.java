package shop.tripass.api.svy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.tripass.api.svy.domain.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
}