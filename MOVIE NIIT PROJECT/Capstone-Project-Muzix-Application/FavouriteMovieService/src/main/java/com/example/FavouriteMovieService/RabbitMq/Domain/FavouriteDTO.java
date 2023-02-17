package com.example.FavouriteMovieService.RabbitMq.Domain;

public class FavouriteDTO {
    private int movieId;
    private String movieName;
    private String email;

    public FavouriteDTO() {
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


}
