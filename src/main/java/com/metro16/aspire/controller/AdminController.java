package com.metro16.aspire.controller;

import com.metro16.aspire.model.Admin;
import com.metro16.aspire.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService service;

    @PostMapping("/admin/add")
    public Admin addAdmin(@RequestBody Admin admin) {
        return service.saveAdmin(admin);
    }

    @GetMapping("/admin/all")
    public List<Admin> findAllClasses() {
        return service.getAdmins();
    }

    @GetMapping("/admin/{id}")
    public Admin findAdminByID(@PathVariable int id) {
        return service.getAdminByID(id);
    }

    @PutMapping("/admin/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return service.updateAdmin(admin);
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        return service.deleteAdmin(id);
    }
}
