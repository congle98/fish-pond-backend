package com.fishpond.service.impl;

import com.fishpond.exceptions.AuthException;
import com.fishpond.model.User;
import com.fishpond.repository.UserRepository;
import com.fishpond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findDistinctByUserName(userName).orElseThrow(()->new AuthException("username hoặc mật khẩu không tồn tại"));
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findDistinctByUserName(userName).orElseThrow(()->new AuthException("username không tồn tại"));
    }
}
