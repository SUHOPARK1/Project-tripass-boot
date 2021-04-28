package shop.tripass.api.rev.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import shop.tripass.api.rev.domain.Review;
import shop.tripass.api.rev.domain.ReviewDto;
import shop.tripass.api.rev.service.ReviewServiceImpl;
import shop.tripass.api.svy.domain.Survey;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping("/review")

public class ReviewController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ReviewServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody ReviewDto t) {
        return ResponseEntity.ok(service.save(t));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody Review t) {
        System.out.println(t.toString());
        return ResponseEntity.ok(service.delete(t));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }
    @GetMapping("/all")
    public ResponseEntity<List<ReviewDto>> findAll() {
        return ResponseEntity.ok(service.findList());
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<Review> getOne(@PathVariable long id) {
        return ResponseEntity.ok(service.getOne(id));
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Review>> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id) {
        return ResponseEntity.ok(service.existsById(id));
    }
    @GetMapping("/list/{contentid}")
    public ResponseEntity<List<ReviewDto>> findRevByPceConentId(@PathVariable String contentid){
        System.out.println(contentid);
        return ResponseEntity.ok(service.findRevByPceConentId(Integer.valueOf(contentid)));
    }
}
