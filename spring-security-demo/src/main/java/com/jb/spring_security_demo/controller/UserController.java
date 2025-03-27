package com.jb.spring_security_demo.controller;
import java.net.Authenticator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jb.spring_security_demo.model.User;
import com.jb.spring_security_demo.service.UserService;

@RestController
public class UserController {

    private UserService service;
    private AuthenticationManager authenticationManager;
    
    

    public UserController(UserService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user)
    {
        Authentication authentication = authenticationManager
                                        .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated())
        {
            return "Success";
        }
        else
        {
            return "Login Failed";
        }
    }

}