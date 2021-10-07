package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.AnswerID;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "student_exam_answer")
public class StudentExamAnswer {
    @EmbeddedId
    private AnswerID answerID;
    private int studentAnswer;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "exam_id")
    @JoinColumn(name = "question")
    private ExamQuestions question;

    @ManyToOne
    @MapsId("studentID")
    @JoinColumn(name = "studentID")
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentExamAnswer that)) return false;
        return getStudentAnswer() == that.getStudentAnswer() && Objects.equals(getAnswerID(), that.getAnswerID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerID(), getStudentAnswer());
    }
}
