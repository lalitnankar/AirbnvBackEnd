package com.airbnb.airbnb.service;

import com.airbnb.airbnb.entity.Users;
import com.airbnb.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    public Users register(Users user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Users();
        }
    }

    public Optional<Users> login(String username, String password) {
        return userRepository.findByUserNameAndPassword(username, password);
    }

}


