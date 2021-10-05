package com.metro16.aspire.model.ID;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class SubjectID implements Serializable {
    private static final long serialVersionUID = -3182249951488948849L;
    protected int classID;
    @Column(length = 20)
    protected String subjectName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectID subjectID = (SubjectID) o;
        return classID == subjectID.classID && Objects.equals(subjectName, subjectID.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classID, subjectName);
    }
}
