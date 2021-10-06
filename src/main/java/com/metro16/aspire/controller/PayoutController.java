package com.metro16.aspire.controller;

import com.metro16.aspire.model.Payout;
import com.metro16.aspire.service.PayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PayoutController {
    @Autowired
    private PayoutService service;

    @PostMapping("/payout/add")
    public Payout addPayout(@RequestBody Payout payout) {
        return service.savePayout(payout);
    }

    @GetMapping("/payout/all")
    public List<Payout> findAllPayouts() {
        return service.getPayouts();
    }

    @GetMapping("/payout/{id}")
    public Payout findPayoutByID(@PathVariable int id) {
        return service.getPayoutByID(id);
    }

    @DeleteMapping("/payout/delete/{id}")
    public String deletePayout(@PathVariable int id) {
        return service.deletePayout(id);
    }
}
