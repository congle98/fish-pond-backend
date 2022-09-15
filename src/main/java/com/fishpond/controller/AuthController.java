package com.fishpond.controller;

import com.fishpond.model.User;
import com.fishpond.sercurityUtils.JwtResponse;
import com.fishpond.sercurityUtils.JwtUtil;
import com.fishpond.sercurityUtils.LoginRequest;
import com.fishpond.service.AuthService;
import com.fishpond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
    }

}
