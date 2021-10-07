package com.metro16.aspire.model.ID;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class QuestionId implements Serializable {
    private static final long serialVersionUID = -2245571647009218119L;
    protected int examID;
    @Column(length = 100)
    protected String question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionId that)) return false;
        return getExamID() == that.getExamID() && Objects.equals(getQuestion(), that.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamID(), getQuestion());
    }
}
