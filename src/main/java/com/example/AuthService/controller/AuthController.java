package com.example.AuthService.controller;

import com.example.AuthService.dto.request.CreateRequest;
import com.example.AuthService.dto.request.LoginRequest;
import com.example.AuthService.dto.response.CreateResponse;
import com.example.AuthService.dto.response.LoginResponse;
import com.example.AuthService.entity.User;
import com.example.AuthService.repository.UserRepository;
import com.example.AuthService.service.AuthService;
import com.example.AuthService.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.oauth2.jwt.JwtEncoder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final AuthService authService;


    @PostMapping("/register")
    public CreateResponse register(@RequestBody CreateRequest createRequest) {
        return userService.register(createRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        log.info("Login attempt for user: {}", request.getUsername());
        return authService.login(request);
    }


}
