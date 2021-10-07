package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.ResultID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "result")
public class Result {
    @EmbeddedId
    private ResultID resultID;
    private double assignmentMarks;
    private double quizMarks;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result result)) return false;
        return Double.compare(result.getAssignmentMarks(), getAssignmentMarks()) == 0 && Double.compare(result.getQuizMarks(), getQuizMarks()) == 0 && Objects.equals(getResultID(), result.getResultID()) && Objects.equals(getStatus(), result.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResultID(), getAssignmentMarks(), getQuizMarks(), getStatus());
    }
}
