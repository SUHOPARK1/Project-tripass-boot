package shop.tripass.api.usr.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tripass.api.usr.domain.User;
interface UserCustomRepository {

}
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository{

    public User findByUsername(String username);

    public Optional<User> findByProviderAndProviderId(String provider, String providerId);

    public Optional<User> findByProviderIdOrEmail(String ProviderId, String Email);

    public Optional<User> findByNum(Long num);

    public boolean existsByProviderId(String providerId);

    public boolean existsByEmail(String email);

    public User findByEmail(String email);

}