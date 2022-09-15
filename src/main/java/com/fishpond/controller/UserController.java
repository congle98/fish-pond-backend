package com.fishpond.controller;

import com.fishpond.model.User;
import com.fishpond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/current-user")
    public ResponseEntity<User> getCurrentUser(Principal principal){
        User user = userService.findUserByUserName(principal.getName());
        user.setPassWord(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
