package com.jb.spring_security_demo.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jb.spring_security_demo.model.User;
import com.jb.spring_security_demo.service.UserService;

@RestController
public class UserController {

    private UserService service;
    
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        return service.saveUser(user);
    }

}