package com.metro16.aspire.service;

import com.metro16.aspire.model.ID.ResultID;
import com.metro16.aspire.model.Result;
import com.metro16.aspire.repositary.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository repository;

    public Result saveResult(Result result) {
        return repository.save(result);
    }

    public List<Result> getResults() {
        return repository.findAll();
    }

    public Result getResultByID(int sid, int term) {
        return repository.findById(new ResultID(sid, term)).orElse(null);
    }

    public String deleteResult(int sid, int term) {
        repository.deleteById(new ResultID(sid, term));
        return "Result deleted by id: " + sid + term;
    }

    public Result updateResult(Result result) {
        Result existingResult = repository.findById(result.getResultID()).orElse(null);
        existingResult.setQuizMarks(result.getQuizMarks());
        existingResult.setAssignmentMarks(result.getAssignmentMarks());
        existingResult.setStatus(result.getStatus());
        return repository.save(existingResult);
    }
}
