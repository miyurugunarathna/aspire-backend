package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {
}
