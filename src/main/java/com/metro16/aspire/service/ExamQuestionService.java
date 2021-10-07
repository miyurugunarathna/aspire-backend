package com.metro16.aspire.service;

import com.metro16.aspire.model.ExamQuestions;
import com.metro16.aspire.model.ID.QuestionId;
import com.metro16.aspire.repositary.ExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionService {
    @Autowired
    private ExamQuestionRepository repository;

    public ExamQuestions saveExamQuestion(ExamQuestions question) {
        return repository.save(question);
    }

    public List<ExamQuestions> getExamQuestions() {
        return repository.findAll();
    }

    public ExamQuestions getExamQuestionByID(int id, String question) {
        return repository.findById(new QuestionId(id, question)).orElse(null);
    }

    public String deleteExamQuestion(int id, String question) {
        repository.deleteById(new QuestionId(id, question));
        return "ExamQuestion deleted by id: " + id;
    }

    public ExamQuestions updateExamQuestion(ExamQuestions question) {
        ExamQuestions existingExamQuestion = repository.findById(question.getQuestionId()).orElse(null);
        existingExamQuestion.setOption1(question.getOption1());
        existingExamQuestion.setOption2(question.getOption2());
        existingExamQuestion.setOption3(question.getOption3());
        existingExamQuestion.setOption4(question.getOption4());
        existingExamQuestion.setCorrectOption(question.getCorrectOption());
        return repository.save(existingExamQuestion);
    }
}
