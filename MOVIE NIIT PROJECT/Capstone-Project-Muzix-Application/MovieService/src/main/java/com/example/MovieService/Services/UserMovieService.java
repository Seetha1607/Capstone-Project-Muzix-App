package com.example.MovieService.Services;

import com.example.MovieService.Domain.User;
import com.example.MovieService.Exception.UserAlreadyExistsException;
import com.example.MovieService.Exception.UserNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface UserMovieService {
    User registerUser(User user, MultipartFile file) throws UserAlreadyExistsException, IOException;
    Optional<User> getUserByEmail(String email) throws UserNotFoundException;


}
