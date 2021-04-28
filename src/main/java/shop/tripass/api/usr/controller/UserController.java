package shop.tripass.api.usr.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import shop.tripass.api.cmm.controller.AbstractController;
import shop.tripass.api.sec.CurrentUser;
import shop.tripass.api.sec.UserPrincipal;
import shop.tripass.api.usr.domain.User;
import shop.tripass.api.usr.domain.UserDto;
import shop.tripass.api.usr.repository.UserRepository;
import shop.tripass.api.usr.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping("/user")

public class UserController extends AbstractController<User>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserRepository userRepository;
    private final UserServiceImpl service;


    @PostMapping("/add")
    public ResponseEntity<Long> save(@RequestBody User t) {
        logger.info("회원 가입정보"+t.toString());
        return ResponseEntity.ok(service.save(t));
    }
    @PostMapping("/login")
    public ResponseEntity<Long> login(@RequestBody User t) {
        logger.info("회원 로그인정보"+t.toString());
        return ResponseEntity.ok(service.save(t));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody User t) {
        return ResponseEntity.ok(service.delete(t));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/list")
    public ResponseEntity<Page<User>> findList(Pageable pageable){
        return ResponseEntity.ok(service.findList(pageable));
    }
    @GetMapping("/one")
    public ResponseEntity<UserDto> getOne(@CurrentUser UserPrincipal userPrincipal) {
        return ResponseEntity.ok(service.getProfile(userPrincipal.getId()));
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id) {
        return ResponseEntity.ok(service.existsById(id));
    }
    @Override   //예외처리
    public ResponseEntity<User> getOne(long id) {
        return null;
    }
}
