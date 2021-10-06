package com.metro16.aspire.service;

import com.metro16.aspire.model.Notifications;
import com.metro16.aspire.repositary.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository repository;

    public Notifications saveNotification(Notifications notification) {
        return repository.save(notification);
    }

    public List<Notifications> getNotifications() {
        return repository.findAll();
    }

    public Notifications getNotificationByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteNotification(int id) {
        repository.deleteById(id);
        return "Admin deleted by id: " + id;
    }

    public Notifications updateNotification(Notifications notification) {
        Notifications existingNotification = repository.findById(notification.getNotificationID()).orElse(null);
        existingNotification.setTitle(notification.getTitle());
        existingNotification.setDescription(notification.getDescription());
        return repository.save(existingNotification);
    }
}
