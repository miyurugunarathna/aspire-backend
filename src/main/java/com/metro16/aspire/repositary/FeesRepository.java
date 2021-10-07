package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeesRepository extends JpaRepository<Fees, Integer> {
    List<Fees> findAllByTeacherID(int person);
}
