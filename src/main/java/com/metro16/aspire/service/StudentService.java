package com.metro16.aspire.service;

import com.metro16.aspire.model.Student;
import com.metro16.aspire.repositary.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudentByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student deleted by id: " + id;
    }

    public Student updateStudent(int id, Student student) {
        Student existingStudent = repository.findById(id).orElse(null);
        existingStudent.setFName(student.getFName());
        existingStudent.setLName(student.getLName());
        existingStudent.setDob(student.getDob());
        existingStudent.setGender(student.getGender());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setActive(student.getActive());
        existingStudent.setApproved(student.getApproved());
        existingStudent.setImgURL(student.getImgURL());
        existingStudent.setPassword(student.getPassword());
        return repository.save(existingStudent);
    }
}
