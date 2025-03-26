package com.jb.spring_security_demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jb.spring_security_demo.model.User;
import com.jb.spring_security_demo.repo.UserRepo;

@Service
public class UserService {

    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User saveUser(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);
    }

}