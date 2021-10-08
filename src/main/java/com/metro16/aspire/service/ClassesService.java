package com.metro16.aspire.service;

import com.metro16.aspire.model.Classes;
import com.metro16.aspire.repositary.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    @Autowired
    private ClassesRepository repository;

    public Classes saveClass(Classes classes) {
        return repository.save(classes);
    }

    public List<Classes> getClasses() {
        return repository.findAll();
    }

    public Classes getClassByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteClass(int id) {
        repository.deleteById(id);
        return "Class deleted by id: " + id;
    }

    public Classes updateClass(Classes classes) {
        Classes existingClass = repository.findById(classes.getClassID()).orElse(null);
        existingClass.setClassName(classes.getClassName());
        return repository.save(existingClass);
    }
}
