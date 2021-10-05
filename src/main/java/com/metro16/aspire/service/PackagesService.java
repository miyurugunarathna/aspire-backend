package com.metro16.aspire.service;

import com.metro16.aspire.model.Packages;
import com.metro16.aspire.repositary.PackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackagesService {
    @Autowired
    private PackagesRepository repository;

    public Packages savePackage(Packages packages) {
        return repository.save(packages);
    }

    public List<Packages> getPackages() {
        return repository.findAll();
    }

    public Packages getPackageByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletePackage(int id) {
        repository.deleteById(id);
        return "Package deleted by id: " + id;
    }

    public Packages updatePackage(Packages packages) {
        Packages existingPackage = repository.findById(packages.getPackageID()).orElse(null);
        existingPackage.setMaxCourse(packages.getMaxCourse());
        existingPackage.setMaxStudent(packages.getMaxStudent());
        existingPackage.setCommission(packages.getCommission());
        existingPackage.setComType(packages.getComType());
        existingPackage.setPackageName(packages.getPackageName());
        existingPackage.setAnnualFee(packages.getAnnualFee());
        existingPackage.setMonthlyFee(packages.getMonthlyFee());
        existingPackage.setDefaultPack(packages.isDefaultPack());
        existingPackage.setModifiedDate(packages.getModifiedDate());
        return repository.save(existingPackage);
    }
}
