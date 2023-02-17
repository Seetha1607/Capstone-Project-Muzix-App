import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  movies1: any = []
  allMovies: any = []
  currentPg: number = 1;

  isLoginSuccess: boolean = false;
  searchKey:string ="";

  searchItem: any;
  searchmovie: any;
  searchedMovies: any = [];
  allSearchedMovies: any = [];
  isReady = false;

  constructor(private movieService: MovieService, private service:LoginService) {
    this.getMovies();
  }

  ngOnInit() {
   
  }

  reset() {
    window.location.reload()
  }

  bannerData() {
    this.movieService.bannerApiData().subscribe((result) => {
      console.log(result, 'bannerresult#');
    });
  }

  getMovies() {
    this.movieService.getAllMovies(this.currentPg).subscribe(res => {
      this.movies1 = res;
      console.log(this.movies1);
      this.allMovies = this.movies1.results;
      console.log(this.allMovies);
    })
  }

  movieDetails(data: any) {
    console.log(data);
    this.movieService.selectedMovie(data);
  }

  decreasePage() {
    this.currentPg--;
    this.getMovies();
  }
  increasePage() {
    this.currentPg++;
    this.getMovies();
  }

  searchRequiredMovie(searchtext: any) {
    this.movieService.searchMovie(searchtext, this.currentPg).subscribe(resp => {
      this.searchedMovies = resp;
      this.allSearchedMovies = this.searchedMovies.results;
      this.allMovies = this.allSearchedMovies;
      // this.movser.storeSearchedMovieToJson(this.allSearchedMovies);
      console.log(this.allSearchedMovies);
      this.isReady = true;
    })
  }

}
