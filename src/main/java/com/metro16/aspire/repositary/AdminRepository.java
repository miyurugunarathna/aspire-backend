package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
