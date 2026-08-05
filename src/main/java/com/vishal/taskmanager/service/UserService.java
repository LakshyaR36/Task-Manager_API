package com.vishal.taskmanager.service;

import com.vishal.taskmanager.dto.LoginRequest;
import com.vishal.taskmanager.dto.LoginResponse;
import com.vishal.taskmanager.dto.RegisterRequest;
import com.vishal.taskmanager.dto.UserResponse;

public interface UserService {
    LoginResponse login(LoginRequest request);
    UserResponse register(RegisterRequest request);

}