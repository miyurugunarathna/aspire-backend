package com.metro16.aspire.model.ID;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class AnswerID implements Serializable {
    private static final long serialVersionUID = -2479442618577634465L;
    @Embedded
    protected QuestionId questionId;
    protected int studentID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerID answerID)) return false;
        return getStudentID() == answerID.getStudentID() && Objects.equals(getQuestionId(), answerID.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getStudentID());
    }
}
