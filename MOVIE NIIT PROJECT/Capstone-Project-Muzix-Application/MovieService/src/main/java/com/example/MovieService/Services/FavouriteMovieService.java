package com.example.MovieService.Services;

import com.example.MovieService.Domain.FavouriteMovie;
import com.example.MovieService.Exception.MovieAlreadyExistsException;
import com.example.MovieService.Exception.MovieNotFoundException;

public interface FavouriteMovieService {
    public FavouriteMovie addMovie(FavouriteMovie favouriteMovie) throws MovieAlreadyExistsException;
    public boolean deleteMovie(int movieId,String email) throws MovieNotFoundException;

}
