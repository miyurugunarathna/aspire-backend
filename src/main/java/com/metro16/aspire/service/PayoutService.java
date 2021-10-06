package com.metro16.aspire.service;

import com.metro16.aspire.model.Payout;
import com.metro16.aspire.repositary.PayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayoutService {
    @Autowired
    private PayoutRepository repository;

    public Payout savePayout(Payout payout) {
        return repository.save(payout);
    }

    public List<Payout> getPayouts() {
        return repository.findAll();
    }

    public Payout getPayoutByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletePayout(int id) {
        repository.deleteById(id);
        return "Payout deleted by id: " + id;
    }
}
