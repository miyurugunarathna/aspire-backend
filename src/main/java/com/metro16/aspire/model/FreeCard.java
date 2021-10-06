package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.StudentEnrollID;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "free_card")
public class FreeCard {
    @EmbeddedId
    private StudentEnrollID enrollID;
    private int startMonth;
    private String description;
    private Date expiryDate;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FreeCard freeCard = (FreeCard) o;
        return enrollID != null && Objects.equals(enrollID, freeCard.enrollID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollID);
    }
}
