package com.metro16.aspire.service;

import com.metro16.aspire.model.ID.CourseID;
import com.metro16.aspire.model.ID.CourseTopicID;
import com.metro16.aspire.model.ID.StudentEnrollID;
import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.model.StudentEnrollCourse;
import com.metro16.aspire.repositary.StudentEnrollCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentEnrollCourseService {
    @Autowired
    private StudentEnrollCourseRepository repository;

    public StudentEnrollCourse saveStudentEnrollCourse(StudentEnrollCourse enroll) {
        return repository.save(enroll);
    }

    public List<StudentEnrollCourse> getStudentEnrollCourses() {
        return repository.findAll();
    }

    public StudentEnrollCourse getStudentEnrollCourseByID(int cid, String name, int tid, int sid) {
        return repository.findById(new StudentEnrollID(new CourseID(new SubjectID(cid, name), tid), sid)).orElse(null);
    }

    public String deleteStudentEnrollCourse(int cid, String name, int tid, int sid) {
        repository.deleteById(new StudentEnrollID(new CourseID(new SubjectID(cid, name), tid), sid));
        return "StudentEnrollCourse deleted by id: " + cid + name + tid + sid;
    }
}
