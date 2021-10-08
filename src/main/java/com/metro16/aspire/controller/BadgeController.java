package com.metro16.aspire.controller;

import com.metro16.aspire.model.Badge;
import com.metro16.aspire.repositary.BadgeRepository;
import com.metro16.aspire.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BadgeController {
    @Autowired
    private BadgeService service;

    @PostMapping("/badge/add")
    public String addBadge(@RequestBody Badge badge) {
        return service.saveBadge(badge);
    }

    @GetMapping("/badge/all")
    public List<Badge> findAllBadges() {
        return service.getBadges();
    }

    @GetMapping("/badge/{id}")
    public Badge findBadgeByID(@PathVariable int id) {
        return service.getBadgeByID(id);
    }

    @PutMapping("/badge/update")
    public String updateBadge(@RequestBody Badge badge) {
        return service.updateBadge(badge);
    }

    @DeleteMapping("/badge/delete/{id}")
    public String deleteBadge(@PathVariable int id) {
        return service.deleteBadge(id);
    }
}
