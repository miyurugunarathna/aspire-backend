package com.metro16.aspire.repositary;

import com.metro16.aspire.model.FreeCard;
import com.metro16.aspire.model.ID.StudentEnrollID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeCardRepository extends JpaRepository<FreeCard, StudentEnrollID> {
}
