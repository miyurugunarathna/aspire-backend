package com.metro16.aspire.controller;

import com.metro16.aspire.model.Fees;
import com.metro16.aspire.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FeesController {
    @Autowired
    private FeesService service;

    @PostMapping("/fee/add")
    public Fees addFee(@RequestBody Fees fee) {
        return service.saveFee(fee);
    }

    @GetMapping("/fee/all")
    public List<Fees> findAllFees() {
        return service.getFees();
    }

    @GetMapping("/fee/{id}")
    public Fees findFeeByID(@PathVariable int id) {
        return service.getFeeByID(id);
    }

    @PutMapping("/fee/update")
    public Fees updateFee(@RequestBody Fees fee) {
        return service.updateFee(fee);
    }

    @DeleteMapping("/fee/delete/{id}")
    public String deleteFee(@PathVariable int id) {
        return service.deleteFee(id);
    }
}
