package com.metro16.aspire.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
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
    private int personID;
    private String type;
    private String fName;
    private String lName;
    private Date dob;
    private String gender;
    private String email;
    private int phone;
    private String imgURL;
    private String password;
    private String status;
    private Date registeredDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return Objects.equals(personID, person.personID);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
