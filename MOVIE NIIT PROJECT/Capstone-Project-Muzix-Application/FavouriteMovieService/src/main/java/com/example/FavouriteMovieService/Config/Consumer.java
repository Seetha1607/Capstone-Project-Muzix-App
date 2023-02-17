/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.FavouriteMovieService.Config;

import com.example.FavouriteMovieService.Domain.FavouriteMovie;
import com.example.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.RabbitMq.Domain.FavouriteDTO;
import com.example.FavouriteMovieService.Services.FavouriteMovieImpl;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private FavouriteMovieImpl favouriteMovie;
    @Autowired
    public Consumer(FavouriteMovieImpl favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }

    @RabbitListener(queuesToDeclare= @Queue("favourite_movie_queue"))
    public void getFavouriteDtoFromRabbitMq(FavouriteDTO favouriteDTO) throws MovieAlreadyExistsException
    {
        FavouriteMovie favourite=new FavouriteMovie();
        favourite.setMovieId(favouriteDTO.getMovieId());
        favourite.setMovieName(favouriteDTO.getMovieName());
        favourite.setEmail(favouriteDTO.getEmail());
        favouriteMovie.saveFavourite(favourite);
    }

}
