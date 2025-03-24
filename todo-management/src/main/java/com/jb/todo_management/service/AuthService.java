package com.jb.todo_management.service;

import com.jb.todo_management.dto.LoginDto;
import com.jb.todo_management.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}//