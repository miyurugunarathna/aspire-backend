package com.metro16.aspire.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classID;
    private String className;
    private Date createdDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "classID", referencedColumnName = "classID")
    @ToString.Exclude
    private Set<Subjects> subjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Classes aClass = (Classes) o;
        return Objects.equals(classID, aClass.classID);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
