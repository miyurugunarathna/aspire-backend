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

    public Badge saveBadge(Badge badge) {
        return repository.save(badge);
    }

    public List<Badge> getBadges() {
        return repository.findAll();
    }

    public Badge getBadgeByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteBadge(int id) {
        repository.deleteById(id);
        return "Badge deleted by id: " + id;
    }

    public Badge updateBadge(Badge badge) {
        Badge existingBadge = repository.findById(badge.getBadgeID()).orElse(null);
        existingBadge.setBadgeName(badge.getBadgeName());
        existingBadge.setDescription(badge.getDescription());
        existingBadge.setConditions(badge.getConditions());
        return repository.save(existingBadge);
    }
}
