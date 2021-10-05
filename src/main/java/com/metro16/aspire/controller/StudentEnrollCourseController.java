package com.metro16.aspire.controller;

import com.metro16.aspire.model.StudentEnrollCourse;
import com.metro16.aspire.service.StudentEnrollCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentEnrollCourseController {
    @Autowired
    private StudentEnrollCourseService service;

    @PostMapping("/studentEnroll/add")
    public StudentEnrollCourse addStudentEnrollCourse(@RequestBody StudentEnrollCourse enroll) {
        return service.saveStudentEnrollCourse(enroll);
    }

    @GetMapping("/studentEnroll/all")
    public List<StudentEnrollCourse> findAllClasses() {
        return service.getStudentEnrollCourses();
    }

    @GetMapping("/studentEnroll/{cid}/{name}/{tid}/{sid}")
    public StudentEnrollCourse findAdminByID(@PathVariable int cid, @PathVariable String name, @PathVariable int tid, @PathVariable int sid) {
        return service.getStudentEnrollCourseByID(cid, name, tid, sid);
    }

    @DeleteMapping("/studentEnroll/delete/{cid}/{name}/{tid}/{sid}")
    public String deleteStudentEnrollCourse(@PathVariable int cid, @PathVariable String name, @PathVariable int tid, @PathVariable int sid) {
        return service.deleteStudentEnrollCourse(cid, name, tid, sid);
    }
}
