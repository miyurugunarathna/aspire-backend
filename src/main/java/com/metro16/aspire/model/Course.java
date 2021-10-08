package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @EmbeddedId
    private CourseID courseID;
    private String description;
    private int feeID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(getCourseID(), course.getCourseID()) && Objects.equals(getDescription(), course.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseID(), getDescription());
    }
}
