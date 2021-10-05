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
public class CourseID implements Serializable {
    private static final long serialVersionUID = -1898696051109755826L;
    @Embedded
    protected SubjectID subjectID;
    protected int teacherID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseID courseID = (CourseID) o;
        return teacherID == courseID.teacherID && Objects.equals(subjectID, courseID.subjectID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectID, teacherID);
    }
}
