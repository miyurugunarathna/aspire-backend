package com.metro16.aspire.controller;

import com.metro16.aspire.model.Packages;
import com.metro16.aspire.service.PackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PackagesController {
    @Autowired
    private PackagesService service;

    @PostMapping("/package/add")
    public Packages addPackage(@RequestBody Packages packages) {
        return service.savePackage(packages);
    }

    @GetMapping("/package/all")
    public List<Packages> findAllPackages() {
        return service.getPackages();
    }

    @GetMapping("/package/{id}")
    public Packages findPackageByID(@PathVariable int id) {
        return service.getPackageByID(id);
    }

    @PutMapping("/package/update")
    public Packages updatePackage(@RequestBody Packages packages) {
        return service.updatePackage(packages);
    }

    @DeleteMapping("/package/delete/{id}")
    public String deletePackage(@PathVariable int id) {
        return service.deletePackage(id);
    }
}
