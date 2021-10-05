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
public class StudentEnrollID implements Serializable {
    private static final long serialVersionUID = -4009468842382394600L;
    @Embedded
    protected CourseID courseID;
    protected int studentID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEnrollID that = (StudentEnrollID) o;
        return studentID == that.studentID && Objects.equals(courseID, that.courseID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseID, studentID);
    }
}
