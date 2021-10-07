package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseID;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examID;
    private String title;
    private Date startTime;
    private Date endTime;
    private boolean visibility;
    @Embedded
    private CourseID courseID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam exam)) return false;
        return getExamID() == exam.getExamID() && isVisibility() == exam.isVisibility() && Objects.equals(getTitle(), exam.getTitle()) && Objects.equals(getStartTime(), exam.getStartTime()) && Objects.equals(getEndTime(), exam.getEndTime()) && Objects.equals(getCourseID(), exam.getCourseID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamID(), getTitle(), getStartTime(), getEndTime(), isVisibility(), getCourseID());
    }
}
