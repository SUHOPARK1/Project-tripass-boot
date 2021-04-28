package shop.tripass.api.crs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tripass.api.crs.domain.CourseDto;
import shop.tripass.api.crs.domain.CourseResponseDto;
import shop.tripass.api.crs.service.CourseService;
import shop.tripass.api.sec.CurrentUser;
import shop.tripass.api.sec.UserPrincipal;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody CourseDto c){
        return ResponseEntity.ok(courseService.save(c));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseResponseDto>> list(@CurrentUser UserPrincipal userPrincipal){
        return ResponseEntity.ok(courseService.list(userPrincipal.getId()));
    }
}