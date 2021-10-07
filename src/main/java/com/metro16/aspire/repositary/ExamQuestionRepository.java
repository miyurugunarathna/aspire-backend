package com.metro16.aspire.repositary;

import com.metro16.aspire.model.ExamQuestions;
import com.metro16.aspire.model.ID.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestions, QuestionId> {
}
