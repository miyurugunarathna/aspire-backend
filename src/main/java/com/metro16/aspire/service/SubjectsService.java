package com.metro16.aspire.service;

import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.model.Subjects;
import com.metro16.aspire.repositary.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {
    @Autowired
    private SubjectsRepository repository;

    public Subjects saveSubject(Subjects subjects) {
        return repository.save(subjects);
    }

    public List<Subjects> getSubjects() {
        return repository.findAll();
    }

    public Subjects getSubjectByID(int id, String name) {
        return repository.findById(new SubjectID(id, name)).orElse(null);
    }

    public String deleteSubject(int id, String name) {
        repository.deleteById(new SubjectID(id, name));
        return "Subject deleted by id: " + id;
    }

    public Subjects updateSubject(Subjects subjects) {
        Subjects existingSubjects = repository.findById(subjects.getSubjectID()).orElse(null);
        existingSubjects.setSubjectID(subjects.getSubjectID());
        existingSubjects.setDescription(subjects.getDescription());
        return repository.save(existingSubjects);
    }
}
