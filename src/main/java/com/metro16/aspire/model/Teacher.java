package com.metro16.aspire.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "teacherid")
public class Teacher extends Person{
    private String qualifititle;
    private String description;
    private String university;
    private int yearFrom;
    private int yearTo;
    private String bank;
    private String branch;
    private int accnum;
    private int packageid;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ToString.Exclude
    private List<Qualification> qualification;*/

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherid")
    @ToString.Exclude
    private Set<Fees> fees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getPersonid(), teacher.getPersonid());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
