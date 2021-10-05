package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseTopicID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
