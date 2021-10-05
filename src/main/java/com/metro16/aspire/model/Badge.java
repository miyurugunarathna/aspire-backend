package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "badge")
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badgeID;
    private String badgeName;
    private String description;
    private String condition;
    private Date createdDate;
    private Date modifiedDate;
    @Embedded
    private CourseID courseID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Badge badge = (Badge) o;
        return badgeID == badge.badgeID && Objects.equals(badgeName, badge.badgeName) && Objects.equals(description, badge.description) && Objects.equals(condition, badge.condition) && Objects.equals(createdDate, badge.createdDate) && Objects.equals(modifiedDate, badge.modifiedDate) && Objects.equals(courseID, badge.courseID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(badgeID, badgeName, description, condition, createdDate, modifiedDate, courseID);
    }
}
