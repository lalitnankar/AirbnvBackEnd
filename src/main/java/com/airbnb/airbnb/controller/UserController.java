package com.airbnb.airbnb.controller;

import com.airbnb.airbnb.Dto.UserRequest;
import com.airbnb.airbnb.Dto.UserResponse;
import com.airbnb.airbnb.entity.Users;
import com.airbnb.airbnb.service.JwtService;
import com.airbnb.airbnb.service.UserService;
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
        String result = userService.register(user);
        userResponse.setUserName(user.getUserName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setAccountCreationDate(user.getAccountCreationDate());
        userResponse.setContactNumber(user.getContactNumber());
        userResponse.setAddressProof(user.getAddressProof());
        userResponse.setIdProof(user.getIdProof());

        return ResponseEntity.ok(userResponse);

    }

    @GetMapping("user/login")
    public  ResponseEntity<UserResponse> userLogin(@RequestBody UserRequest userRequest)
    {
        UserResponse userResponse = new UserResponse();
        Optional<Users> userLogin = userService.login(userRequest.getUserName(),userRequest.getPassword());
        String token = jwtService.generateToken(userLogin);
        if(userLogin != null)
        {
            userResponse.setMessage("Login sucessfull");
            userResponse.setToken(token);
        }
        else{
            userResponse.setMessage("Login not sucessfull");
        }
        return ResponseEntity.ok(userResponse);
    }


}
