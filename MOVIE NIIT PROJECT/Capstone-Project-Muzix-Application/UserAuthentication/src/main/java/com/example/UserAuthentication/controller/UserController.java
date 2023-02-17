package com.example.UserAuthentication.controller;

import com.example.UserAuthentication.domain.UserModel;
import com.example.UserAuthentication.exception.UserAlreadyExistException;
import com.example.UserAuthentication.exception.UserNotFoundException;
import com.example.UserAuthentication.service.SecurityTokenGenerator;
import com.example.UserAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class UserController
{
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService , SecurityTokenGenerator securityTokenGenerator)
    {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?>  saveUser(@RequestBody UserModel userModel) throws UserAlreadyExistException {
        return  new ResponseEntity<>(userService.addUser(userModel), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody UserModel user ) throws Exception {
        userService.loginCheck(user.getEmail(), user.getPassword());
        Map<String,String> secretkey = new HashMap<>();
        secretkey = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(secretkey, HttpStatus.OK);
    }

}
