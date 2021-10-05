package com.metro16.aspire.service;

import com.metro16.aspire.model.Admin;
import com.metro16.aspire.repositary.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }

    public List<Admin> getAdmins() {
        return repository.findAll();
    }

    public Admin getAdminByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteAdmin(int id) {
        repository.deleteById(id);
        return "Admin deleted by id: " + id;
    }

    public Admin updateAdmin(Admin admin) {
        Admin existingAdmin = repository.findById(admin.getAdminID()).orElse(null);
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setName(admin.getName());
        return repository.save(existingAdmin);
    }
}
