package com.metro16.aspire.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personid;
    private String type;
    private String fName;
    private String lName;
    private String dob;
    private String gender;
    @Column(unique = true)
    private String email;
    private int phone;
    private String imgURL;
    private String password;
    private String active;
    private String approved;
    private Date registeredDate;

    @OneToMany
    @JoinColumn(name = "repliedPersonID")
    @ToString.Exclude
    private List<Reply> replies;

    @ManyToMany
    @JoinTable(
            name = "notification_assign",
            joinColumns = @JoinColumn(name = "personid"),
            inverseJoinColumns = @JoinColumn(name = "notificationID")
    )
    @ToString.Exclude
    private List<Notifications> notifications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return Objects.equals(personid, person.personid);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
