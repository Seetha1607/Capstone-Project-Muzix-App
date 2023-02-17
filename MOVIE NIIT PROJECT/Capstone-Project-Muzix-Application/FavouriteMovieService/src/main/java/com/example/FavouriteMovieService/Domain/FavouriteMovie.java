/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.FavouriteMovieService.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FavouriteMovie {

    @Id
    private int movieId;
    private String movieName;
    private String email;

    public FavouriteMovie(int movieId, String movieName, String email) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.email = email;
    }

    public FavouriteMovie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FavouriteMovie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
