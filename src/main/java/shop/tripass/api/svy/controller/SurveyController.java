package shop.tripass.api.svy.controller;

import shop.tripass.api.svy.service.SurveyService;
import shop.tripass.api.svy.domain.SurveyDto;
import shop.tripass.api.svy.domain.SurveyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/survey")
public class SurveyController {
    private final SurveyService surveyService;

    @PostMapping("/save")
    public ResponseEntity<List<List<SurveyResponseDto>>> save(@RequestBody SurveyDto s){
        return ResponseEntity.ok(surveyService.saveAndRecom(s));}

    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(surveyService.count());
    }

    @GetMapping("/list")
    public ResponseEntity<Page<SurveyDto>> list(Pageable pageable){
        return ResponseEntity.ok(surveyService.list(pageable)); }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> delete(@RequestBody SurveyDto s){
        return ResponseEntity.ok(surveyService.delete(s)); } }