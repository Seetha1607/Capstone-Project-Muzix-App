/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.MovieService.controller;

import com.example.MovieService.Domain.User;
import com.example.MovieService.Exception.UserAlreadyExistsException;
import com.example.MovieService.Exception.UserNotFoundException;
import com.example.MovieService.Services.UserMovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class UserMovieController {

    private UserMovieService userMovieService;
    ResponseEntity responseEntity;


    @Autowired
    public UserMovieController(UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam("file") MultipartFile file,@RequestParam("user") String user) throws UserAlreadyExistsException, IOException {
        User user1 = new ObjectMapper().readValue(user, User.class);
        try {
           return new ResponseEntity<>(userMovieService.registerUser(user1,file),HttpStatus.OK);
        }
        catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException();
        }
        catch (Exception e) {
            return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        try {
//            responseEntity = new ResponseEntity<>(userMovieService.registerUser(user), HttpStatus.CREATED);
//        } catch (UserAlreadyExistsException e) {
//            throw new UserAlreadyExistsException();
//        }
//        return responseEntity;
    }
    @GetMapping("/registers/{email}")
    public ResponseEntity<?> getUserbyEmail(@PathVariable String email) throws UserNotFoundException {
        try{
            responseEntity = new ResponseEntity<>(userMovieService.getUserByEmail(email), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
}
