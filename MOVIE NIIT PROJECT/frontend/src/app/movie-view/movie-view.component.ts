import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Movies } from '../models/models/movies';
import { MovieService } from '../movie.service';
import { PlayComponent } from '../play/play.component';

@Component({
  selector: 'app-movie-view',
  templateUrl: './movie-view.component.html',
  styleUrls: ['./movie-view.component.css']
})
export class MovieViewComponent {

  private api_key: string = "78b0fbe3e0365430eb677a6c8b9382df";
  latestMovie!: Movies[];
  selectedMovieData: any;
  movies!: Movies[];
  movieId!: number;
  movies1: any = [];
  favouriteMovieId: number = 0;
  favouriteMovieName: any;
  particularMovieGenre: any;
  alert: boolean = false;
  warningAlert: boolean = false;
  currentPage!: any
  trailerKey: any;

  posterBaseUrl: string = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2";
  backdropBaseUrl: string = "https://www.themoviedb.org/t/p/w1066_and_h600_bestv2";
  constructor(private movieService: MovieService, private dialog: MatDialog,private snackBar:MatSnackBar) {
  }


  ngOnInit(): void {

    console.log("-------------------");
    this.selectedMovieData = this.movieService.movieInfo;
    console.log(this.selectedMovieData);
    this.getMovieData();
  }

  fetchAllMovies() {
    this.movieService.getAllMovies(this.currentPage).subscribe(response => {
      this.movies = response.results;
      console.log(response);
      console.log(this.movies);
    }, err => {
      window.alert("Error while fetching the latest movies!" + err)
    })
    //https://www.themoviedb.org/t/p/w600_and_h900_bestv2/r9PkFnRUIthgBp2JZZzD380MWZy.jpg

  }

  addToFavourite(selectedMovieData: any) {
    this.favouriteMovieId = selectedMovieData.id;
    this.favouriteMovieName = selectedMovieData.original_title;
    this.movieService.addMovieToFavourites(this.favouriteMovieId, this.favouriteMovieName).subscribe({
      next: () => {
        console.log(this.favouriteMovieId,this.favouriteMovieName);
        this.snackBar.open("Success!! Movie added to your favourites!!", "Close", { duration: 3000 });
      },
      error: (err) => {
        if (err.status === 500) {
          this.snackBar.open("This movie is already added to your favourites", "Close", { duration: 3000 });
        } else {
          this.snackBar.open("Internal server error!", "Close", { duration: 3000 });
        }
      }
    });
  }
  
  // .subscribe((res) => {
  //   console.log(res);
  //   this.alert = true;
  //   this.snackBar.open("Success!! Movie added to your favourites!!","Close",{duration:3000})
  // },
  // (err:any) => {
  //   if (err.status === 409) {
  //     window.alert("This email is already taken! Try with other valid email!");
  //   } else {
  //     this.snackBar.open("Internal server error!", "Close", {duration: 3000});
  //   }
  // })

  passRecommended(movieTitle: string) {
    this.movieService.movieName = movieTitle;
  }
  closeAlert() {
    this.alert = false;
    this.warningAlert = false;
  }
  getMovieData() {
    this.movieService.getParticularMovieDetails(this.selectedMovieData.id).subscribe(res => {
      this.movies1 = res;
      console.log("this is genres");
      console.log(this.movies1);
      this.movieService.recommendedMovieId = this.movies1.id;
      this.particularMovieGenre = this.movies1.genres;
    });
  }

  responseKey: any = {};
  trailerUrl: string = "";

  playView: boolean = true;
  zaxis: number = -10;
  playTrailor() {
    if (this.playView) {
      this.playView = false;
      this.zaxis = 0;
      console.log(this.playView)
    }
    else {
      this.playView = true;
      this.zaxis = -10;
    }
  }

  openDialog(): void {
    this.movieService.getTrailor(this.movies1.id).then((data) => {
      this.responseKey = data;
      for (let obj of this.responseKey.results) {
        if (obj.name.includes("Trailer")) {
          let key = obj.key
          this.trailerKey = obj.key;
          const dialogRef = this.dialog.open(PlayComponent, {

            data: { 'key': key },
            height: "170px",
            width: "300px"
          })
        }
      }
    })
  }
}