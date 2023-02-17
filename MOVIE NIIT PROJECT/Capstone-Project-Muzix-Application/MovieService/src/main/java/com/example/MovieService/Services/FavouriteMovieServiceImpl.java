package com.example.MovieService.Services;

import com.example.MovieService.Config.Producer;
import com.example.MovieService.Domain.FavouriteMovie;
import com.example.MovieService.Exception.MovieAlreadyExistsException;
import com.example.MovieService.Exception.MovieNotFoundException;
import com.example.MovieService.RabbitMq.Domain.FavouriteDTO;
import com.example.MovieService.Repository.FavouriteMovieRepository;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouriteMovieServiceImpl implements FavouriteMovieService {
    FavouriteMovieRepository favouriteMovieRepository;
    private Optional<FavouriteMovie> favMovie;
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
    @Autowired
    Producer producer;

    @Autowired
    public FavouriteMovieServiceImpl(FavouriteMovieRepository favouriteMovieRepository, Optional<FavouriteMovie> favMovie, RabbitTemplate rabbitTemplate, DirectExchange directExchange, Producer producer) {
        this.favouriteMovieRepository = favouriteMovieRepository;
        this.favMovie = favMovie;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
        this.producer = producer;
    }


    /**
     * This function is used to add a movie to the favourite list
     *
     * @param favouriteMovie The movie that is to be added to the favourite list.
     * @return The movie is being returned.
     */
    @Override
    // Adding a movie to the favourite list.
    // This method is used to add a movie to the favourite list.
    public FavouriteMovie addMovie(FavouriteMovie favouriteMovie) throws MovieAlreadyExistsException {
        FavouriteDTO favouriteDTO = new FavouriteDTO();
        favouriteDTO.setMovieId(favouriteMovie.getMovieId());
        favouriteDTO.setMovieName(favouriteMovie.getMovieName());
        favouriteDTO.setEmail(favouriteMovie.getEmail());
        if (favouriteMovieRepository.findById(favouriteMovie.getMovieId()).isPresent()) {
            favMovie = getFavouriteMovieByMovieId(favouriteMovie.getMovieId());
            if (favouriteMovie.getEmail().equals(favMovie.get().getEmail())) {
                throw new MovieAlreadyExistsException();
            } else {
//                favouriteMovieRepository.save(favouriteMovie);
                System.out.println("saved user in mongo");
                producer.sendMessageToRabbitMq(favouriteDTO);
            }
        } else {
//            favouriteMovieRepository.save(favouriteMovie);
            System.out.println("saved user in mongo");
            producer.sendMessageToRabbitMq(favouriteDTO);
        }
        return favouriteMovie;
    }

    /**
     * > It returns an Optional of FavouriteMovie, which is the result of calling findById on the favouriteMovieRepository
     *
     * @param movieId The id of the movie to be deleted.
     * @return The method returns an Optional object.
     */
    public Optional<FavouriteMovie> getFavouriteMovieByMovieId(int movieId){
        return favouriteMovieRepository.findById(movieId);
    }

    /**
     * The function deletes a movie from the favourite list of a user
     *
     * @param movieId The id of the movie to be deleted.
     * @param email The email of the user who has added the movie to the favourite list.
     * @return A boolean value.
     */
    @Override
    // Deleting a movie from the favourite list.
    public boolean deleteMovie(int movieId, String email) throws MovieNotFoundException {
        favouriteMovieRepository.deleteByMovieIdAndEmail(movieId,email);
        return true;
    }

}
