package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseID;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "badge")
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badgeID;
    @Embedded
    private CourseID courseID;
    private String badgeName;
    private String description;
    private String conditions;
    private Date createdDate;
    private Date modifiedDate;
}
