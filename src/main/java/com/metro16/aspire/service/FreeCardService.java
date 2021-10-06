package com.metro16.aspire.service;

import com.metro16.aspire.model.FreeCard;
import com.metro16.aspire.model.ID.CourseID;
import com.metro16.aspire.model.ID.CourseTopicID;
import com.metro16.aspire.model.ID.StudentEnrollID;
import com.metro16.aspire.model.ID.SubjectID;
import com.metro16.aspire.repositary.FreeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeCardService {
    @Autowired
    private FreeCardRepository repository;

    public FreeCard saveFreeCard(FreeCard freeCard) {
        return repository.save(freeCard);
    }

    public List<FreeCard> getFreeCards() {
        return repository.findAll();
    }

    public FreeCard getFreeCardByID(int cid, String name, int tid, int sid) {
        return repository.findById(new StudentEnrollID(new CourseID(new SubjectID(cid, name), tid), sid)).orElse(null);
    }

    public String deleteFreeCard(int cid, String name, int tid, int sid) {
        repository.deleteById(new StudentEnrollID(new CourseID(new SubjectID(cid, name), tid), sid));
        return "FreeCard deleted by id: " + cid + name + tid + sid;
    }

    public FreeCard updateFreeCard(FreeCard freeCard) {
        FreeCard existingFreeCard = repository.findById(freeCard.getEnrollID()).orElse(null);
        return repository.save(existingFreeCard);
    }
}
