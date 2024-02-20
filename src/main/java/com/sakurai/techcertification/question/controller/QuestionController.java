package com.sakurai.techcertification.question.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.sakurai.techcertification.question.model.PublicQuestionDto;
import com.sakurai.techcertification.question.model.Question;
import com.sakurai.techcertification.question.model.RegistrationQuestionDto;
import com.sakurai.techcertification.question.service.QuestionService;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @PostMapping()
    public ResponseEntity<Object> registerQuestion(@RequestBody RegistrationQuestionDto question,
                                                    UriComponentsBuilder ucb) {
        Question registeredQuestion = this.questionService.registerQuestion(question);
        URI uri = ucb
            .path("/questions/{questionTechnology}")
            .buildAndExpand(registeredQuestion.getTechnology())
            .toUri();

        return ResponseEntity.created(uri).build();
    }


    @GetMapping("/{technology}")
    public ResponseEntity<List<PublicQuestionDto>> findByTechnology(@PathVariable String technology,
                                                    UriComponentsBuilder ucb) {
        try {
            List<PublicQuestionDto> questions = questionService.findByTechnology(technology.toUpperCase());
            return ResponseEntity.ok().body(questions);
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
