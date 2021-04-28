package shop.tripass.api.usr.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import shop.tripass.api.usr.domain.User;

@Repository

public class UserRepositoryImpl extends QuerydslRepositorySupport
implements UserCustomRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }
}
