package com.example.FavouriteMovieService.Services;

import com.example.FavouriteMovieService.Domain.FavouriteMovie;
import com.example.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.Exception.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IFavouriteMovieService {
    FavouriteMovie saveFavourite(FavouriteMovie favourite) throws MovieAlreadyExistsException;
    FavouriteMovie findByMovieId(int movieId);
    List<FavouriteMovie> findMoviesByEmail(String email);
    boolean deleteMovieFromFavourites(int movieId,String email) throws MovieNotFoundException;
}
