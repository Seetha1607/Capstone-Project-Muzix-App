import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { Movies } from './models/models/movies';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  movieName:string | undefined;
  movieInfo: any;
  currentPage:number=1;
  recommendedMovieId:any;
  email:any;
  favMovieObj:any={};

  constructor(private http:HttpClient, private router:Router) { }

  private api_key: string = "78b0fbe3e0365430eb677a6c8b9382df";
  
  baseUrl : string= "https://api.themovie.db.org/3";

  getLatestMovies() :Observable<any>{
    let url = `https://api.themoviedb.org/3/movie/latest?api_key=${this.api_key}&append_to_response=credits`;
    return this.http.get<any>(url);
  }

  bannerApiData():Observable<any>{
    let url = `https://api.themoviedb.org/3/trending/all/week?api_key=${this.api_key}`;
    return this.http.get<any>(url);
  }
// Search movies
searchMovie(searchItem:any,currentPage:number){
  console.log("i am inside the movie service");
  console.log(searchItem);
  let searchUrl=`https://api.themoviedb.org/3/search/movie?api_key=${this.api_key}&language=es&query=${searchItem}&page=${currentPage}`
  console.log(searchUrl);
  return this.http.get(searchUrl);
}

  selectedMovie(data: any) {
    this.movieInfo = data;
    this.router.navigate(['/movie-view']);
  }

  getParticularMovieDetails(movieId:number)
  {
    let url = `https://api.themoviedb.org/3/movie/${movieId}?api_key=${this.api_key}&append_to_response=credits`;
    return this.http.get<any>(url);
  }
   

  getAllMovies(currentPage:number) {
    let url = `https://api.themoviedb.org/3/discover/movie?api_key=${this.api_key}&page=${currentPage}`;
    return this.http.get<any>(url);
  }

  addMovieToFavourites(movieId:number,movieName:any){    
    this.favMovieObj.movieId=movieId;
    this.favMovieObj.movieName=movieName;
    this.favMovieObj.email=localStorage.getItem('emailId')
    return this.http.post("http://localhost:8081/api/v3/registerFavouriteMovie",this.favMovieObj);
  }
  

  getAllRecommendedMovies(recMovieId:number)
  {
    let recommendedUrl=`https://api.themoviedb.org/3/movie/${recMovieId}/recommendations?api_key=${this.api_key}&language=en-US&page=1`;
    return this.http.get(recommendedUrl);
  }

  getFavouriteMoviesByEmail()
  {
    return this.http.get("http://localhost:8082/api/v4/favourite/"+localStorage.getItem('emailId'))
  }

  getAllFavouriteMoviesFromApi(movieId:number){
    let url = `https://api.themoviedb.org/3/movie/${movieId}?api_key=${this.api_key}&append_to_response=credits`;
    return this.http.get<any>(url);
  } 

  deleteFavouriteMovie(delMovieId:String){
    return this.http.delete("http://localhost:8081/api/v3/deleteFavourite/"+delMovieId+"/"+this.email);
  }
  
  deleteFavouriteFromMovieService(delMovieId:String,email1:any){
    return this.http.delete("http://localhost:8082/api/v4/deleteFavourite/"+delMovieId+"/"+email1);
  }

  getTrailor(id:number) {
    return new Promise((res, rej) => {
     this.http.get(`https://api.themoviedb.org/3/movie/${id}/videos?api_key=${this.api_key}&language=en-US`).subscribe(data => {
       res(data);
     })
   })
 }

  getNowPlayingMovies():Observable<Movies> {
    let url = `https://api.themoviedb.org/3/movie/now_playing?api_key=78b0fbe3e0365430eb677a6c8b9382df`;
    return this.http.get<Movies>(url);
  }
  getTopRatedMovies():Observable<Movies> {
    let url = `https://api.themoviedb.org/3/movie/top_rated?api_key=78b0fbe3e0365430eb677a6c8b9382df`;
    return this.http.get<Movies>(url);
  }
  getUpcomingMovies():Observable<Movies> {
    let url = `https://api.themoviedb.org/3/movie/upcoming?api_key=78b0fbe3e0365430eb677a6c8b9382df`;
    return this.http.get<Movies>(url);
  }

  getTrendingMovies():Observable<Movies> {
    let url = `https://api.themoviedb.org/3/trending/all/week?api_key=78b0fbe3e0365430eb677a6c8b9382df`;
    return this.http.get<Movies>(url);
  }

  getOriginals():Observable<Movies> {
    let url = `https://api.themoviedb.org/3/discover/tv?api_key=78b0fbe3e0365430eb677a6c8b9382df`;
    return this.http.get<Movies>(url);
  }

}
