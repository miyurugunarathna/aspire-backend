package com.metro16.aspire.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "qualification")
public class Qualification {
    @Id
    private int teacherID;
    private String qualification;
    private String description;
    private String university;
    private int yearFrom;
    private int yearTo;
    private String attachmentURL;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Qualification that = (Qualification) o;
        return Objects.equals(teacherID, that.teacherID);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
