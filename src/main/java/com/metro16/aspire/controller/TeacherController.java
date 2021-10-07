package com.metro16.aspire.controller;

import com.metro16.aspire.model.Teacher;
import com.metro16.aspire.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private TeacherService service;

    @PostMapping("/teacher/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return service.saveTeacher(teacher);
    }

    @GetMapping("/teacher/all")
    public List<Teacher> findAllTeachers() {
        return service.getTeachers();
    }

    @GetMapping("/teacher/{id}")
    public Teacher findTeacherByID(@PathVariable int id) {
        return service.getTeacherByID(id);
    }

    @PutMapping("/teacher/update")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return service.updateTeacher(teacher);
    }

    @DeleteMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable int id) {
        return service.deleteTeacher(id);
    }
}
