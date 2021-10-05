package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.StudentEnrollID;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "student_enroll_course")
public class StudentEnrollCourse {
    @EmbeddedId
    private StudentEnrollID enrollID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentEnrollCourse that = (StudentEnrollCourse) o;
        return enrollID != null && Objects.equals(enrollID, that.enrollID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollID);
    }
}
