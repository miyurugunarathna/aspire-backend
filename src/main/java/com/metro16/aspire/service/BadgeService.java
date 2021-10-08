package com.metro16.aspire.service;

import com.metro16.aspire.model.Badge;
import com.metro16.aspire.repositary.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {
    @Autowired
    private BadgeRepository repository;

    public String saveBadge(Badge badge) {
        repository.save(badge);
        return "Badge added successfully.";
    }

    public List<Badge> getBadges() {
        return repository.findAll();
    }

    public Badge getBadgeByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteBadge(int id) {
        repository.deleteById(id);
        return "Badge deleted successfully.";
    }

    public String updateBadge(Badge badge) {
        Badge existingBadge = repository.findById(badge.getBadgeID()).orElse(null);
        existingBadge.setBadgeName(badge.getBadgeName());
        existingBadge.setDescription(badge.getDescription());
        existingBadge.setConditions(badge.getConditions());
        repository.save(existingBadge);
        return "Badge updated successfully.";
    }
}
