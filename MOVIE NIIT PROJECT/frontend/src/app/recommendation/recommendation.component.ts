import { Component } from '@angular/core';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.css']
})
export class RecommendationComponent {
  titleMovie: string | undefined;
  recommendedMovies: any;
  allRecommendedMovies: any;
  currentPg: number = 1;
  searchItem: any;
  searchmovie: any;
  searchedMovies: any = [];
  allSearchedMovies: any = [];
  isReady = false;
  allMovies: any = []
  movies1: any = []


  constructor(private movieService: MovieService) {
    this.titleMovie = this.movieService.movieName;
  }
  ngOnInit(): void {
    this.movieService.getAllRecommendedMovies(this.movieService.recommendedMovieId).subscribe(res => {
      this.recommendedMovies = res;
      this.allRecommendedMovies = this.recommendedMovies.results;
      console.log("this is the recommended movies");
      console.log(this.allRecommendedMovies);
    });
  }
  movieDetails(data: any) {
    this.movieService.selectedMovie(data);
  }

  searchRequiredMovie(searchtext: any) {
    this.movieService.searchMovie(searchtext, this.currentPg).subscribe(resp => {
      this.searchedMovies = resp;
      this.allRecommendedMovies = this.searchedMovies.results;
      this.allMovies = this.allRecommendedMovies;
      // this.movser.storeSearchedMovieToJson(this.allSearchedMovies);
      console.log(this.allRecommendedMovies);
      this.isReady = true;
    })
  }
  getMovies() {
    this.movieService.getAllMovies(this.currentPg).subscribe(res => {
      this.movies1 = res;
      console.log(this.movies1);
      this.allMovies = this.movies1.results;
      console.log(this.allMovies);
    })
  }

  decreasePage() {
    this.currentPg--;
    this.getMovies();
  }
  increasePage() {
    this.currentPg++;
    this.getMovies();
  }

  reset() {
    window.location.reload()
  }

}
