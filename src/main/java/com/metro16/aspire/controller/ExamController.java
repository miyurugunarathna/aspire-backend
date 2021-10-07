package com.metro16.aspire.controller;

import com.metro16.aspire.model.Exam;
import com.metro16.aspire.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ExamController {
    @Autowired
    private ExamService service;

    @PostMapping("/exam/add")
    public Exam addExam(@RequestBody Exam exam) {
        return service.saveExam(exam);
    }

    @GetMapping("/exam/all")
    public List<Exam> findAllExams() {
        return service.getExams();
    }

    @GetMapping("/exam/{id}")
    public Exam findExamByID(@PathVariable int id) {
        return service.getExamByID(id);
    }

    @PutMapping("/exam/update")
    public Exam updateExam(@RequestBody Exam exam) {
        return service.updateExam(exam);
    }

    @DeleteMapping("/exam/delete/{id}")
    public String deleteExam(@PathVariable int id) {
        return service.deleteExam(id);
    }
}
