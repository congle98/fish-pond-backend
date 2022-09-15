package com.fishpond.service;

import com.fishpond.model.User;

public interface UserService {
    User findUserByUserName(String userName);
}
