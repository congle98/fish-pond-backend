package com.fishpond.service.impl;

import com.fishpond.model.User;
import com.fishpond.sercurityUtils.JwtResponse;
import com.fishpond.sercurityUtils.JwtUtil;
import com.fishpond.sercurityUtils.LoginRequest;
import com.fishpond.service.AuthService;
import com.fishpond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassWord()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);
        User user = userService.findUserByUserName(authentication.getName());
        return new JwtResponse(jwt,user);
    }
}
