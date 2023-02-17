/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.MovieService.controller;

import com.example.MovieService.Domain.FavouriteMovie;
import com.example.MovieService.Exception.MovieAlreadyExistsException;
import com.example.MovieService.Exception.MovieNotFoundException;
import com.example.MovieService.Services.FavouriteMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/v3")

public class FavouriteMovieController {

    private FavouriteMovieService favouriteMovieService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public FavouriteMovieController(FavouriteMovieService favouriteMovieService) {
        this.favouriteMovieService = favouriteMovieService;
    }

    @PostMapping("/registerFavouriteMovie")
    public ResponseEntity<?> registerFavourite(@RequestBody FavouriteMovie favouriteMovie) throws MovieAlreadyExistsException {
        try {
            responseEntity =  new ResponseEntity<>(favouriteMovieService.addMovie(favouriteMovie), HttpStatus.CREATED);
        }
        catch(MovieAlreadyExistsException e)
        {
            throw new MovieAlreadyExistsException();
        }
        catch (Exception e) {
            return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/deleteFavourite/{movieId}/{email}")
    public ResponseEntity<?> deleteMovieFromFavourites(@PathVariable int movieId,@PathVariable String email) throws MovieNotFoundException
    {
        try
        {
            responseEntity=new ResponseEntity<>(favouriteMovieService.deleteMovie(movieId,email),HttpStatus.OK);
        }
        catch(MovieNotFoundException e){
            throw new MovieNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("message");
        System.out.println(responseEntity);
        return responseEntity;
    }
}
