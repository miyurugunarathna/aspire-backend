package com.metro16.aspire.service;

import com.metro16.aspire.model.Questions;
import com.metro16.aspire.repositary.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    public Questions saveQuestion(Questions question) {
        return repository.save(question);
    }

    public List<Questions> getQuestions() {
        return repository.findAll();
    }

    public Questions getQuestionByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteQuestion(int id) {
        repository.deleteById(id);
        return "Admin deleted by id: " + id;
    }

    public Questions updateQuestion(Questions question) {
        Questions existingQuestion = repository.findById(question.getQuestionID()).orElse(null);
        existingQuestion.setTitle(question.getTitle());
        existingQuestion.setDescription(question.getDescription());
        return repository.save(existingQuestion);
    }
}
