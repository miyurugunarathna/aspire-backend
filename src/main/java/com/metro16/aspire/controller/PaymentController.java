package com.metro16.aspire.controller;

import com.metro16.aspire.model.Admin;
import com.metro16.aspire.model.Payment;
import com.metro16.aspire.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping("/payment/add")
    public Payment addPayment(@RequestBody Payment payment) {
        return service.savePayment(payment);
    }

    @GetMapping("/payment/all")
    public List<Payment> findAllPayments() {
        return service.getPayments();
    }

    @GetMapping("/payment/{id}")
    public Payment findPaymentByID(@PathVariable int id) {
        return service.getPaymentByID(id);
    }

    @PutMapping("/payment/update")
    public Payment updatePayment(@RequestBody Payment payment) {
        return service.updatePayment(payment);
    }

    @DeleteMapping("/payment/delete/{id}")
    public String deletePayment(@PathVariable int id) {
        return service.deletePayment(id);
    }
}
