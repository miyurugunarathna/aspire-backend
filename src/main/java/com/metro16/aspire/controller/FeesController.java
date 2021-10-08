package com.metro16.aspire.controller;

import com.metro16.aspire.model.Fees;
import com.metro16.aspire.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class FeesController {
    @Autowired
    private FeesService service;

    @PostMapping("/fee/add")
    public String addFee(@RequestBody Fees fee, Authentication authentication) {
        return service.saveFee(fee, authentication.getName());
    }

    @RequestMapping(value = "/fee/all", method = RequestMethod.GET)
    public List<Fees> findAllFees(Authentication authentication) {
        return service.getFees(authentication.getName());
    }

    @GetMapping("/fee/{id}")
    public Fees findFeeByID(@PathVariable int id) {
        return service.getFeeByID(id);
    }

    @PutMapping("/fee/update")
    public String updateFee(@RequestBody Fees fee) {
        return service.updateFee(fee);
    }

    @DeleteMapping("/fee/delete/{id}")
    public String deleteFee(@PathVariable int id) {
        return service.deleteFee(id);
    }
}
