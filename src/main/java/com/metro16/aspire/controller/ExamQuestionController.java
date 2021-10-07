package com.metro16.aspire.controller;

import com.metro16.aspire.model.ExamQuestions;
import com.metro16.aspire.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ExamQuestionController {
    @Autowired
    private ExamQuestionService service;

    @PostMapping("/examQuestion/add")
    public ExamQuestions addExamQuestion(@RequestBody ExamQuestions question) {
        return service.saveExamQuestion(question);
    }

    @GetMapping("/examQuestion/all")
    public List<ExamQuestions> findAllExamQuestions() {
        return service.getExamQuestions();
    }

    @GetMapping("/examQuestion/{id}/{question}")
    public ExamQuestions findExamQuestionByID(@PathVariable int id, @PathVariable String question) {
        return service.getExamQuestionByID(id, question);
    }

    @PutMapping("/examQuestion/update")
    public ExamQuestions updateExamQuestion(@RequestBody ExamQuestions question) {
        return service.updateExamQuestion(question);
    }

    @DeleteMapping("/examQuestion/delete/{id}/{question}")
    public String deleteExamQuestion(@PathVariable int id, @PathVariable String question) {
        return service.deleteExamQuestion(id, question);
    }
}
