package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
