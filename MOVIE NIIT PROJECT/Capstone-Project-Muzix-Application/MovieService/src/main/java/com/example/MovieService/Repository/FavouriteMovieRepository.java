package com.example.MovieService.Repository;
import com.example.MovieService.Domain.FavouriteMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteMovieRepository extends MongoRepository<FavouriteMovie, Integer> {
    FavouriteMovie findByMovieId(int movieId);
    boolean deleteByMovieIdAndEmail(int movieId,String email);
    FavouriteMovie findByEmail(String email);
}
