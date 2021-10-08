package com.metro16.aspire.service;

import com.metro16.aspire.model.Teacher;
import com.metro16.aspire.repositary.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;

    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    public List<Teacher> getTeachers() {
        return repository.findAll();
    }

    public Teacher getTeacherByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteTeacher(int id) {
        repository.deleteById(id);
        return "Teacher deleted by id: " + id;
    }

    public Teacher updateTeacher(int id, Teacher teacher) {
        Teacher existingTeacher = repository.findById(id).orElse(null);
        existingTeacher.setFName(teacher.getFName());
        existingTeacher.setLName(teacher.getLName());
        existingTeacher.setDob(teacher.getDob());
        existingTeacher.setGender(teacher.getGender());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhone(teacher.getPhone());
        existingTeacher.setImgURL(teacher.getImgURL());
        existingTeacher.setPassword(teacher.getPassword());
        existingTeacher.setPackageid(teacher.getPackageid());

        existingTeacher.setQualifititle(teacher.getQualifititle());
        existingTeacher.setDescription(teacher.getDescription());
        existingTeacher.setUniversity(teacher.getUniversity());
        existingTeacher.setYearFrom(teacher.getYearFrom());
        existingTeacher.setYearTo(teacher.getYearTo());

        existingTeacher.setBank(teacher.getBank());
        existingTeacher.setBranch(teacher.getBranch());
        existingTeacher.setAccnum(teacher.getAccnum());
        existingTeacher.setActive(teacher.getActive());

        return repository.save(existingTeacher);
    }
}
