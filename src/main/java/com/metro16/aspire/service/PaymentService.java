package com.metro16.aspire.service;

import com.metro16.aspire.model.Payment;
import com.metro16.aspire.repositary.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }

    public List<Payment> getPayments() {
        return repository.findAll();
    }

    public Payment getPaymentByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletePayment(int id) {
        repository.deleteById(id);
        return "Admin deleted by id: " + id;
    }

    public Payment updatePayment(Payment payment) {
        Payment existingPayment = repository.findById(payment.getPaymentID()).orElse(null);
        existingPayment.setStatusCode(payment.getStatusCode());
        existingPayment.setStatusMessage(payment.getStatusMessage());
        return repository.save(existingPayment);
    }
}
