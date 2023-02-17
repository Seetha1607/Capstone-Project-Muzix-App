package com.example.UserAuthentication.service;

import com.example.UserAuthentication.domain.UserModel;
import com.example.UserAuthentication.exception.UserAlreadyExistException;
import com.example.UserAuthentication.exception.UserNotFoundException;

public interface UserService
{
    public abstract UserModel addUser(UserModel user) throws UserAlreadyExistException;
    public abstract UserModel loginCheck(String email , String userPassword) throws UserNotFoundException;
    UserModel fetchUserByEmailAndPassword(String email, String password);


}
