package com.jb.todo_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jb.todo_management.dto.RegisterDto;
import com.jb.todo_management.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
//registe new user 
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto)
    {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
