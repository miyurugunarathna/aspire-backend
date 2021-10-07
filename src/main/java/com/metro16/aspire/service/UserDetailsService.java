package com.metro16.aspire.service;

import com.metro16.aspire.model.Person;
import com.metro16.aspire.repositary.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private PersonRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = repository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(person.getEmail(), person.getPassword(), new ArrayList<>());
    }

    public Person loadUserByEmail(String email) {
        return  repository.findByEmail(email);
    }
}
