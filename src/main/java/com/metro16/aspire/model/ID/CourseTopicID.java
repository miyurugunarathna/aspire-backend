package com.metro16.aspire.model.ID;

import lombok.*;

import javax.persistence.Column;
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
public class CourseTopicID implements Serializable {
    private static final long serialVersionUID = 9191369657162376298L;
    @Embedded
    protected CourseID courseID;
    @Column(length = 40)
    protected String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTopicID that = (CourseTopicID) o;
        return Objects.equals(courseID, that.courseID) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseID, title);
    }
}
