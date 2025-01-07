package com.airbnb.airbnb.service;

import com.airbnb.airbnb.entity.Users;
import com.airbnb.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    public String register(Users user){

      String result = " ";
      try {
          Users saved = userRepository.save(user);
          result = user.getUserName()+"saved sucessfully";

      }catch(Exception e) {
        result = " not saved sucessfully";
      }

     return result;
    }
 public Optional<Users> login(String username, String password)
 {
     return  userRepository.findByUserNameAndPassword(username,password);
 }

    }


