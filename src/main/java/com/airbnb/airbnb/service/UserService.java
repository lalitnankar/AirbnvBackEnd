package com.airbnb.airbnb.service;

import com.airbnb.airbnb.entity.Users;

import java.util.Optional;

public interface UserService {
    Users register(Users users);
    Optional<Users> login(String username, String password);
}
