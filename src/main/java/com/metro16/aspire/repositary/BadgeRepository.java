package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Integer> {
}
