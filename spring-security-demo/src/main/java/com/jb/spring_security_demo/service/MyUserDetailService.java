package com.jb.spring_security_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jb.spring_security_demo.model.User;
import com.jb.spring_security_demo.model.UserPrincipal;
import com.jb.spring_security_demo.repo.UserRepo;
@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        User user = repo.findByUsername(username);
        if(user == null)
        {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);

    }

}
