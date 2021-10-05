package com.metro16.aspire.controller;

import com.metro16.aspire.model.Classes;
import com.metro16.aspire.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassesController {
    @Autowired
    private ClassesService service;

    @PostMapping("/class/add")
    public Classes addClass(@RequestBody Classes classes) {
        return service.saveClass(classes);
    }

    @GetMapping("/class/all")
    public List<Classes> findAllClasses() {
        return service.getClasses();
    }

    @GetMapping("/class/{id}")
    public Classes findClassByID(@PathVariable int id) {
        return service.getClassByID(id);
    }

    @PutMapping("/class/update")
    public Classes updateClass(@RequestBody Classes classes) {
        return service.updateClass(classes);
    }

    @DeleteMapping("/class/delete/{id}")
    public String deleteClass(@PathVariable int id) {
        return service.deleteClass(id);
    }
}
