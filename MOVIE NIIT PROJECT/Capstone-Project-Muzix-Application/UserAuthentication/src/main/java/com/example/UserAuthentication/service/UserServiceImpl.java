package com.example.UserAuthentication.service;

import com.example.UserAuthentication.domain.UserModel;
import com.example.UserAuthentication.exception.UserAlreadyExistException;
import com.example.UserAuthentication.exception.UserNotFoundException;
import com.example.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository= userRepository;
    }

    @Override
    public UserModel addUser(UserModel user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        else {
            return userRepository.save(user);
        }

    }

    @Override
    public UserModel loginCheck(String email, String userPassword) throws UserNotFoundException
    {
        UserModel user = userRepository.findByEmailAndPassword(email,userPassword);
        if(user!=null){ //authentication is ok
            return user;
        }
        else{ // authentication failed
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserModel fetchUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
