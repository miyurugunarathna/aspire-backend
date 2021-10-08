package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.SubjectID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "subject")
public class Subjects {
    @EmbeddedId
    private SubjectID subjectID;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Subjects subject = (Subjects) o;
        return Objects.equals(subjectID, subject.subjectID);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
