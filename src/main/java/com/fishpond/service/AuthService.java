package com.fishpond.service;

import com.fishpond.sercurityUtils.JwtResponse;
import com.fishpond.sercurityUtils.LoginRequest;

public interface AuthService {

    JwtResponse login(LoginRequest loginRequest);
}
