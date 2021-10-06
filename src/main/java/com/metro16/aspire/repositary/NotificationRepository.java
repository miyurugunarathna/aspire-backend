package com.metro16.aspire.repositary;

import com.metro16.aspire.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {
}
