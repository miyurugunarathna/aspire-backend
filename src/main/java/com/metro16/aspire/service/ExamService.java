package com.metro16.aspire.service;

import com.metro16.aspire.model.Exam;
import com.metro16.aspire.repositary.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    private ExamRepository repository;

    public Exam saveExam(Exam exam) {
        return repository.save(exam);
    }

    public List<Exam> getExams() {
        return repository.findAll();
    }

    public Exam getExamByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteExam(int id) {
        repository.deleteById(id);
        return "Exam deleted by id: " + id;
    }

    public Exam updateExam(Exam exam) {
        Exam existingExam = repository.findById(exam.getExamID()).orElse(null);
        existingExam.setTitle(exam.getTitle());
        existingExam.setStartTime(exam.getStartTime());
        existingExam.setEndTime(exam.getEndTime());
        existingExam.setVisibility(exam.isVisibility());
        return repository.save(existingExam);
    }
}
