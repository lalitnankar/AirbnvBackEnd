package com.airbnb.airbnb.controller;

import com.airbnb.airbnb.Dto.UserRequest;
import com.airbnb.airbnb.Dto.UserResponse;
import com.airbnb.airbnb.entity.Users;
import com.airbnb.airbnb.service.JwtService;
import com.airbnb.airbnb.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserServiceImp userService;

    @Autowired
    JwtService jwtService;

    @PostMapping("/user/register")
    public ResponseEntity<UserResponse> userRegister(@RequestBody Users user) {
        UserResponse userResponse = new UserResponse();
        Users result = userService.register(user);
        userResponse.setUserName(result.getUserName());
        userResponse.setEmail(result.getEmail());
        userResponse.setPassword(result.getPassword());
        userResponse.setAccountCreationDate(result.getAccountCreationDate());
        userResponse.setContactNumber(result.getContactNumber());
        userResponse.setAddressProof(result.getAddressProof());
        userResponse.setIdProof(result.getIdProof());

        return ResponseEntity.ok(userResponse);

    }

    @GetMapping("user/login")
    public ResponseEntity<UserResponse> userLogin(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        Optional<Users> userLogin = userService.login(userRequest.getUserName(), userRequest.getPassword());
        String token = jwtService.generateToken(userLogin);
        if (userLogin.isPresent()) {
            userResponse.setMessage("Login successful");
            userResponse.setToken(token);
        } else {
            userResponse.setMessage("Login not successful");
        }
        return ResponseEntity.ok(userResponse);
    }


}
