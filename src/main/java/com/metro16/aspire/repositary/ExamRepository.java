package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
