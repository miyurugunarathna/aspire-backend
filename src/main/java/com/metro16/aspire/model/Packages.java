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
@Table(name = "package")
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;
    private int maxCourse;
    private int maxStudent;
    private double commission;
    private String comType;
    private String packageName;
    private double annualFee;
    private double monthlyFee;
    private boolean defaultPack;
    private Date createdDate;
    private Date modifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Packages packages = (Packages) o;
        return Objects.equals(packageID, packages.packageID);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
