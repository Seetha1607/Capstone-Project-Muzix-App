/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.FavouriteMovieService.Controller;

import com.example.FavouriteMovieService.Domain.FavouriteMovie;
import com.example.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.Exception.MovieNotFoundException;
import com.example.FavouriteMovieService.Services.FavouriteMovieImpl;
import com.example.FavouriteMovieService.Services.IFavouriteMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/v4")
public class FavouriteMovieController {

    private IFavouriteMovieService iFavouriteMovieService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public FavouriteMovieController(IFavouriteMovieService iFavouriteMovieService) {
        this.iFavouriteMovieService = iFavouriteMovieService;
    }


    @PostMapping("/favourite")
    public ResponseEntity<?> saveFavourite(@RequestBody FavouriteMovie favourite) throws MovieAlreadyExistsException {
        return new ResponseEntity<>(iFavouriteMovieService.saveFavourite(favourite), HttpStatus.CREATED);
    }


    @GetMapping("favourite/{email}")
    public ResponseEntity<?> getFavouriteMoviesByEmail(@PathVariable String email) throws Exception
    {
        return new ResponseEntity<>(iFavouriteMovieService.findMoviesByEmail(email),HttpStatus.OK);
    }

    @DeleteMapping("/deleteFavourite/{movieId}/{email}")
    public ResponseEntity<?> deleteMovieFromFavourites(@PathVariable int movieId,@PathVariable String email) throws MovieNotFoundException
    {
        try
        {
            responseEntity=new ResponseEntity<>(iFavouriteMovieService.deleteMovieFromFavourites(movieId,email),HttpStatus.OK);
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
