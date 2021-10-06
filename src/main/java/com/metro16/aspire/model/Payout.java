package com.metro16.aspire.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "payout")
public class Payout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payoutID;
    private String type;
    private String currency;
    private double netAmount;
    private String status;
    private double commission;
    private double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payout payout)) return false;
        return getPayoutID() == payout.getPayoutID() && Double.compare(payout.getNetAmount(), getNetAmount()) == 0 && Double.compare(payout.getCommission(), getCommission()) == 0 && Double.compare(payout.getAmount(), getAmount()) == 0 && Objects.equals(getType(), payout.getType()) && Objects.equals(getCurrency(), payout.getCurrency()) && Objects.equals(getStatus(), payout.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPayoutID(), getType(), getCurrency(), getNetAmount(), getStatus(), getCommission(), getAmount());
    }
}
