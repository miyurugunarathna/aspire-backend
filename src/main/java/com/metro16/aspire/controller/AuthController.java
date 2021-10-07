package com.metro16.aspire.controller;

import com.metro16.aspire.model.AuthRequest;
import com.metro16.aspire.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to aspire";
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/auth/login")
    public ResponseEntity generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("trouble " + authRequest);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid credential");
        }
        String token = jwtUtil.generateToken(authRequest.getUserName());
        Map<Object, Object> model = new HashMap<>();
        model.put("token", token);
        return ResponseEntity.ok(model);
    }
}
