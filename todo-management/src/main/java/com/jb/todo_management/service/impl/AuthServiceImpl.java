package com.jb.todo_management.service.impl;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jb.todo_management.dto.LoginDto;
import com.jb.todo_management.dto.RegisterDto;
import com.jb.todo_management.entity.Role;
import com.jb.todo_management.entity.User;
import com.jb.todo_management.exception.TodoAPIException;
import com.jb.todo_management.repository.RoleRepository;
import com.jb.todo_management.repository.UserRepository;
import com.jb.todo_management.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    
    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String register(RegisterDto registerDto) 
    {
        if(userRepository.existsByUsername(registerDto.getUsername()))
        {
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Username Already Exists");
        }
        if(userRepository.existsByEmail(registerDto.getEmail()))
        {
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Email Already Exists");
        }

        User user = new User();
        user.setId(registerDto.getId());
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);
        return "User Registered Successfully";

    }

    @Override
    public String login(LoginDto loginDto) 
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User Logged in Successfully";
    }
}