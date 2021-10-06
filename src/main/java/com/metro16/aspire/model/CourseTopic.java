package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseTopicID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "course_topic")
public class CourseTopic {
    @EmbeddedId
    private CourseTopicID courseTopicID;
    private String description;
    private String url;

    @ManyToOne
    @JoinColumn(name = "classID", referencedColumnName = "classID", insertable = false, updatable = false)
    @JoinColumn(name = "subjectName", referencedColumnName = "subjectName", insertable = false, updatable = false)
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID", insertable = false, updatable = false)
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTopic that = (CourseTopic) o;
        return Objects.equals(courseTopicID, that.courseTopicID) && Objects.equals(description, that.description) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseTopicID, description, url);
    }
}
