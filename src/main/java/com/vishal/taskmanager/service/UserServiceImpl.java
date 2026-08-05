package com.vishal.taskmanager.service;

import com.vishal.taskmanager.dto.LoginRequest;
import com.vishal.taskmanager.dto.LoginResponse;
import com.vishal.taskmanager.dto.RegisterRequest;
import com.vishal.taskmanager.dto.UserResponse;
import com.vishal.taskmanager.entity.Role;
import com.vishal.taskmanager.entity.User;
import com.vishal.taskmanager.exception.EmailAlreadyExistsException;
import com.vishal.taskmanager.exception.InvalidCredentialsException;
import com.vishal.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // Business logic will go here

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
        String token = jwtService.generateToken(user);
        return LoginResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public UserResponse register(RegisterRequest request) {
        Optional<User> existingUser =
                userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException(
                    "Email already registered."
            );
        }
        String hashedPassword =
                passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .passwordHash(hashedPassword)
                .role(Role.USER)
                .build();
        User savedUser = userRepository.save(user);
        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
}