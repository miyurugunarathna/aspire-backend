package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.QuestionId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "exam_questions")
public class ExamQuestions {
    @EmbeddedId
    private QuestionId questionId;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int correctOption;

    @OneToMany(mappedBy = "question")
    @ToString.Exclude
    Set<StudentExamAnswer> answers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamQuestions that)) return false;
        return getCorrectOption() == that.getCorrectOption() && Objects.equals(getQuestionId(), that.getQuestionId()) && Objects.equals(getOption1(), that.getOption1()) && Objects.equals(getOption2(), that.getOption2()) && Objects.equals(getOption3(), that.getOption3()) && Objects.equals(getOption4(), that.getOption4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getOption1(), getOption2(), getOption3(), getOption4(), getCorrectOption());
    }
}
