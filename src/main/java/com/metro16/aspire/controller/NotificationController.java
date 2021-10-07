package com.metro16.aspire.controller;

import com.metro16.aspire.model.Notifications;
import com.metro16.aspire.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    private NotificationService service;

    @PostMapping("/notification/add")
    public Notifications addNotification(@RequestBody Notifications notification) {
        return service.saveNotification(notification);
    }

    @GetMapping("/notification/all")
    public List<Notifications> findAllNotifications() {
        return service.getNotifications();
    }

    @GetMapping("/notification/{id}")
    public Notifications findNotificationByID(@PathVariable int id) {
        return service.getNotificationByID(id);
    }

    @PutMapping("/notification/update")
    public Notifications updateNotification(@RequestBody Notifications notification) {
        return service.updateNotification(notification);
    }

    @DeleteMapping("/notification/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        return service.deleteNotification(id);
    }
}
