/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.FavouriteMovieService.Services;

import com.example.FavouriteMovieService.Domain.FavouriteMovie;
import com.example.FavouriteMovieService.Exception.MovieAlreadyExistsException;
import com.example.FavouriteMovieService.Exception.MovieNotFoundException;
import com.example.FavouriteMovieService.Repository.FavouriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteMovieImpl implements IFavouriteMovieService{

    private FavouriteMovieRepository favouriteMovieRepository;

    private FavouriteMovie favMovie;
    @Autowired
    public FavouriteMovieImpl(FavouriteMovieRepository favouriteMovieRepository) {
        this.favouriteMovieRepository = favouriteMovieRepository;
    }

    @Override
    public FavouriteMovie saveFavourite(FavouriteMovie favourite) throws MovieAlreadyExistsException {
        if(favouriteMovieRepository.findById(favourite.getMovieId()).isPresent())
        {
            favMovie=findByMovieId(favourite.getMovieId());
            if(favourite.getEmail().equals(favMovie.getEmail()))
            {
                throw new MovieAlreadyExistsException();
            }
            System.out.println(favourite);
            return favouriteMovieRepository.save(favourite);
        }
        System.out.println(favourite);
        return favouriteMovieRepository.save(favourite);
    }

    @Override
    public FavouriteMovie findByMovieId(int movieId){
        System.out.println("movieId"+movieId);
        FavouriteMovie favourite = favouriteMovieRepository.findByMovieId(movieId);
        System.out.println(favourite);
//        if(favourite == null)
//        {
//            throw new MovieAlreadyExistsException();
//        }
        return favourite;
    }

    @Override
    public List<FavouriteMovie> findMoviesByEmail(String email) {
        return favouriteMovieRepository.findAllMoviesByEmail(email);
    }

    @Override
    public boolean deleteMovieFromFavourites(int movieId,String email) throws MovieNotFoundException {
        favouriteMovieRepository.deleteByMovieIdAndEmail(movieId,email);
        return true;
    }
}
