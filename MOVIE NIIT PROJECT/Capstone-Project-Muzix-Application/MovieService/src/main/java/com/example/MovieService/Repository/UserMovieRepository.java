package com.example.MovieService.Repository;
import com.example.MovieService.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMovieRepository extends MongoRepository<User, String> {

    public Optional<User> findById(String email);
}
