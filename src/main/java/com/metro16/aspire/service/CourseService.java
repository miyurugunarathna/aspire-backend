package com.metro16.aspire.service;

import com.metro16.aspire.model.Course;
import com.metro16.aspire.model.ID.CourseID;
import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.repositary.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getCourses() {
        return repository.findAll();
    }

    public Course getCourseByID(int cid, String name, int tid) {
        return repository.findById(new CourseID(new SubjectID(cid, name), tid)).orElse(null);
    }

    public String deleteCourse(int cid, String name, int tid) {
        repository.deleteById(new CourseID(new SubjectID(cid, name), tid));
        return "Course deleted by id: " + cid;
    }

    public Course updateCourse(Course course) {
        Course existingCourse = repository.findById(course.getCourseID()).orElse(null);
        existingCourse.setDescription(course.getDescription());
        return repository.save(existingCourse);
    }
}
