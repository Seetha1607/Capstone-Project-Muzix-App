package com.example.FavouriteMovieService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Movie already exist")
public class MovieAlreadyExistsException extends Exception{
}
