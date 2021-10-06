package com.metro16.aspire.controller;

import com.metro16.aspire.model.Questions;
import com.metro16.aspire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @PostMapping("/question/add")
    public Questions addQuestion(@RequestBody Questions question) {
        return service.saveQuestion(question);
    }

    @GetMapping("/question/all")
    public List<Questions> findAllQuestions() {
        return service.getQuestions();
    }

    @GetMapping("/question/{id}")
    public Questions findQuestionByID(@PathVariable int id) {
        return service.getQuestionByID(id);
    }

    @PutMapping("/question/update")
    public Questions updateQuestion(@RequestBody Questions question) {
        return service.updateQuestion(question);
    }

    @DeleteMapping("/question/delete/{id}")
    public String deleteQuestion(@PathVariable int id) {
        return service.deleteQuestion(id);
    }
}
