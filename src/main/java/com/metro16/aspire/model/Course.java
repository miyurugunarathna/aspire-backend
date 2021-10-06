package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<CourseTopic> topics;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "c_feeID", referencedColumnName = "feeID")
    private Fees fee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseID, course.courseID) && Objects.equals(description, course.description) && Objects.equals(fee, course.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseID, description, fee);
    }
}
