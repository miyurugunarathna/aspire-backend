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
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "studentID")
public class Student extends Person{

    @ManyToMany
    @JoinTable(
            name = "student_enroll_course",
            joinColumns = @JoinColumn(name = "studentID"),
            inverseJoinColumns = {
                    @JoinColumn(name = "classID"),
                    @JoinColumn(name = "subjectName"),
                    @JoinColumn(name = "teacherID")
            }
    )
    @ToString.Exclude
    private List<Course> courses;

    @ManyToMany
    @JoinTable(
            name = "earn_badge",
            joinColumns = @JoinColumn(name = "studentID"),
            inverseJoinColumns = @JoinColumn(name = "badgeID")
    )
    @ToString.Exclude
    private List<Badge> badges;
}
