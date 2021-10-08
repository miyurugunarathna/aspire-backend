package com.metro16.aspire.service;

import com.metro16.aspire.model.Fees;
import com.metro16.aspire.repositary.FeesRepository;
import com.metro16.aspire.repositary.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeesService {
    @Autowired
    private FeesRepository repository;
    @Autowired
    private PersonRepository personRepository;

    public Fees saveFee(Fees fees) {
        return repository.save(fees);
    }

    public List<Fees> getFees(String email) {
        System.out.println(email);
        int person = personRepository.findByEmail(email).getPersonid();
        return repository.findAllByTeacherID(person);
    }

    public Fees getFeeByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteFee(int id) {
        repository.deleteById(id);
        return "Fee deleted by id: " + id;
    }

    public Fees updateFee(Fees fees) {
        Fees existingFee = repository.findById(fees.getFeeID()).orElse(null);
        assert existingFee != null;
        existingFee.setFeesName(fees.getFeesName());
        existingFee.setFeesType(fees.getFeesType());
        existingFee.setAmount(fees.getAmount());
        existingFee.setFrequency(fees.getFrequency());
        return repository.save(existingFee);
    }
}
