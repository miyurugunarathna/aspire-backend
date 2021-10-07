package com.metro16.aspire.repositary;

import com.metro16.aspire.model.ID.ResultID;
import com.metro16.aspire.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, ResultID> {
}
