package com.metro16.aspire.controller;

import com.metro16.aspire.model.ID.ResultID;
import com.metro16.aspire.model.Result;
import com.metro16.aspire.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    private ResultService service;

    @PostMapping("/result/add")
    public Result addResult(@RequestBody Result result) {
        return service.saveResult(result);
    }

    @GetMapping("/result/all")
    public List<Result> findAllResults() {
        return service.getResults();
    }

    @GetMapping("/result/{sid}/{term}")
    public Result findResultByID(@PathVariable int sid, @PathVariable int term) {
        return service.getResultByID(sid, term);
    }

    @PutMapping("/result/update")
    public Result updateAdmin(@RequestBody Result admin) {
        return service.updateResult(admin);
    }

    @DeleteMapping("/result/delete/{sid}/{term}")
    public String deleteResult(@PathVariable int sid, @PathVariable int term) {
        return service.deleteResult(sid, term);
    }
}
