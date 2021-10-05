package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
