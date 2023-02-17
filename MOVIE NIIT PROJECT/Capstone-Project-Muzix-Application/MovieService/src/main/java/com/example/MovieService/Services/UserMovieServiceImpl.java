package com.example.MovieService.Services;

import com.example.MovieService.Domain.User;
import com.example.MovieService.Exception.UserAlreadyExistsException;
import com.example.MovieService.Exception.UserNotFoundException;
import com.example.MovieService.Proxy.UserProxy;
import com.example.MovieService.Repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserMovieServiceImpl implements UserMovieService{
    private UserMovieRepository userMovieRepository;
    private UserProxy userProxy;

    @Autowired
    public UserMovieServiceImpl(UserMovieRepository userMovieRepository, UserProxy userProxy) {
        this.userMovieRepository = userMovieRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User registerUser(User user, MultipartFile file) throws UserAlreadyExistsException, IOException {
        if (userMovieRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        else {
            userProxy.registerUser(user);
            user.setImage(file.getBytes());
            user.setImageName(file.getOriginalFilename());
            userMovieRepository.save(user);
            //System.out.println(responseEntity.getBody());
        }
        return user;
    }

    @Override
    public Optional<User> getUserByEmail(String email) throws UserNotFoundException {
        if(userMovieRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userMovieRepository.findById(email);
    }
}
