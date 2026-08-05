package com.vishal.taskmanager.controller;


import com.vishal.taskmanager.dto.LoginRequest;
import com.vishal.taskmanager.dto.LoginResponse;
import com.vishal.taskmanager.dto.RegisterRequest;
import com.vishal.taskmanager.dto.UserResponse;
import com.vishal.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request){
        return userService.register(request);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
