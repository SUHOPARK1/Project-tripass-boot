package shop.tripass.api.usr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.tripass.api.cmm.service.AbstractService;
import shop.tripass.api.usr.domain.User;
import shop.tripass.api.usr.domain.UserDto;
import shop.tripass.api.usr.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<User> implements UserService {
    private final UserRepository repo;


    @Override
    public long save(User t) {
        return (repo.save(t) != null) ? 1 : 0;}

    @Override
    public long delete(User t) {
        repo.delete(t); return (existsById(t.getNum())) ? 0 : 1;}

    @Override
    public long count() {
        return (long)repo.count();}

    @Override
    public User getOne(long id) {
        return repo.getOne(id);}


    @Override
    public Optional<User> findById(long id) {
        return repo.findById(id);}

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);}

    @Override
    public List<User> findAll() {
        return repo.findAll();}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    public Page<User> findList(Pageable pageable) {return repo.findAll(pageable);}

    public UserDto getProfile(long id) {
        return new UserDto(repo.getOne(id));}
}