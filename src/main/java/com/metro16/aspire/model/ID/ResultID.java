package com.metro16.aspire.model.ID;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class ResultID implements Serializable {
    private static final long serialVersionUID = -1898696051109755826L;
    protected int studentID;
    protected int term;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultID resultID)) return false;
        return getStudentID() == resultID.getStudentID() && getTerm() == resultID.getTerm();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentID(), getTerm());
    }
}
