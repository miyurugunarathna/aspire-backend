package com.metro16.aspire.controller;

import com.metro16.aspire.model.Course;
import com.metro16.aspire.model.Fees;
import com.metro16.aspire.service.CourseService;
import com.metro16.aspire.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService service;
    @Autowired
    private FeesService feesService;

    @PostMapping("/course/add")
    public Course addCourse(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    @GetMapping("/course/all")
    public List<Course> findAllCourses() {
        return service.getCourses();
    }

    @GetMapping("/course/{cid}/{name}/{tid}")
    public Course findCourseByID(@PathVariable int cid, @PathVariable String name, @PathVariable int tid) {
        return service.getCourseByID(cid, name, tid);
    }

    @PutMapping("/course/update")
    public Course updateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }

    @PutMapping("/course/{cid}/{name}/{tid}/fee/{fid}")
    public Course addCourseFee(@PathVariable int cid, @PathVariable String name, @PathVariable int tid, @PathVariable int fid) {
        Course existCourse = service.getCourseByID(cid, name, tid);
        Fees existFee = feesService.getFeeByID(fid);
        existCourse.setFee(existFee);
        return service.updateCourse(existCourse);
    }

    @DeleteMapping("/course/delete/{cid}/{name}/{tid}")
    public String deleteCourse(@PathVariable int cid, @PathVariable String name, @PathVariable int tid) {
        return service.deleteCourse(cid, name, tid);
    }
}
