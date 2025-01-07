package com.airbnb.airbnb.service;

import com.airbnb.airbnb.entity.Users;

import java.util.Optional;

public interface UserService {
    public String register(Users users);
    public Optional<Users> login (String username, String password);
}
