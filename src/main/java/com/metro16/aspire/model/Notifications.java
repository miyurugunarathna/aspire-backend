package com.metro16.aspire.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "notification")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationID;
    private String description;
    private String title;
    private Date createdDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notifications that)) return false;
        return getNotificationID() == that.getNotificationID() && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getCreatedDate(), that.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNotificationID(), getDescription(), getTitle(), getCreatedDate());
    }
}
