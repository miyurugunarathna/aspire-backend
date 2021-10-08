package com.metro16.aspire.controller;

import com.metro16.aspire.model.Classes;
import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.model.Subjects;
import com.metro16.aspire.service.ClassesService;
import com.metro16.aspire.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SubjectsController {
    @Autowired
    private SubjectsService service;

    @PostMapping("/subject/add/{id}")
    public Subjects addSubject(@RequestBody Subjects subjects, @PathVariable int id) {
        System.out.println(subjects);
        subjects.setSubjectID(new SubjectID(id, subjects.getSubjectID().getSubjectName()));
        Subjects newSub = service.saveSubject(subjects);
        return newSub;
    }

    @GetMapping("/subject/all/{cid}")
    public List<Subjects> findAllSubjectsByID(@PathVariable int cid) {
        return service.getSubjectsByClassID(cid);
    }

    @GetMapping("/subject/{id}/{name}")
    public Subjects findSubjectByID(@PathVariable int id, @PathVariable String name) {
        return service.getSubjectByID(id, name);
    }

    @PutMapping("/subject/update")
    public Subjects updateSubject(@RequestBody Subjects subjects) {
        return service.updateSubject(subjects);
    }

    @DeleteMapping("/subject/delete/{id}/{name}")
    public String deleteSubject(@PathVariable int id, @PathVariable String name) {
        return service.deleteSubject(id, name);
    }
}
