package com.metro16.aspire.controller;

import com.metro16.aspire.model.FreeCard;
import com.metro16.aspire.service.FreeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FreeCardController {
    @Autowired
    private FreeCardService service;

    @PostMapping("/freeCard/add")
    public FreeCard addFreeCard(@RequestBody FreeCard freeCard) {
        return service.saveFreeCard(freeCard);
    }

    @GetMapping("/freeCard/all")
    public List<FreeCard> findAllFreeCards() {
        return service.getFreeCards();
    }

    @GetMapping("/freeCard/{cid}/{name}/{tid}/{sid}")
    public FreeCard findAdminByID(@PathVariable int cid, @PathVariable String name, @PathVariable int tid, @PathVariable int sid) {
        return service.getFreeCardByID(cid, name, tid, sid);
    }

    @DeleteMapping("/freeCard/delete/{cid}/{name}/{tid}/{sid}")
    public String deleteFreeCard(@PathVariable int cid, @PathVariable String name, @PathVariable int tid, @PathVariable int sid) {
        return service.deleteFreeCard(cid, name, tid, sid);
    }
}
