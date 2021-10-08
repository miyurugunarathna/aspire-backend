package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.CourseID;
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
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;
    private Date issuedDate;
    private double amount;
    private String statusMessage;
    private String method;
    private String currency;
    private int statusCode;
    private String description;
    @Embedded
    private CourseID courseID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return getPaymentID() == payment.getPaymentID() && Double.compare(payment.getAmount(), getAmount()) == 0 && getStatusCode() == payment.getStatusCode() && Objects.equals(getIssuedDate(), payment.getIssuedDate()) && Objects.equals(getStatusMessage(), payment.getStatusMessage()) && Objects.equals(getMethod(), payment.getMethod()) && Objects.equals(getCurrency(), payment.getCurrency()) && Objects.equals(getDescription(), payment.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentID(), getIssuedDate(), getAmount(), getStatusMessage(), getMethod(), getCurrency(), getStatusCode(), getDescription());
    }
}
