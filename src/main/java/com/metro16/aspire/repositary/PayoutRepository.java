package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Payout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayoutRepository extends JpaRepository<Payout, Integer> {
}
