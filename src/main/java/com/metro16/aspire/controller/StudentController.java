package com.metro16.aspire.controller;

import com.metro16.aspire.model.Student;
import com.metro16.aspire.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/student/all")
    public List<Student> findAllStudents() {
        return service.getStudents();
    }

    @GetMapping("/student/get/{id}")
    public Student findStudentByID(@PathVariable int id) {
        return service.getStudentByID(id);
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
