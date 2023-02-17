package com.example.FavouriteMovieService.Repository;


import com.example.FavouriteMovieService.Domain.FavouriteMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteMovieRepository extends MongoRepository<FavouriteMovie, Integer> {

    FavouriteMovie findByMovieId(int movieId);
    List<FavouriteMovie> findAllMoviesByEmail(String email);
    boolean deleteByMovieIdAndEmail(int movieId,String email);
}