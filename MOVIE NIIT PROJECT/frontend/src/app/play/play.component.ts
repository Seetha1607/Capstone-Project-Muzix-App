import { Component,Inject, OnInit} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MovieViewComponent } from '../movie-view/movie-view.component';

@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit{
  key = this.data.key;
  trailerUrl:any
  constructor(public dialogRef: MatDialogRef<PlayComponent>, @Inject(MAT_DIALOG_DATA) public data: {key:any}){}
  ngOnInit(): void {
    console.log(this.key)
    this.playMovie()
    console.log(this.trailerUrl);
  }

  
  playMovie(){
    this.trailerUrl = `//www.youtube.com/embed/${this.key}`;
  }

}
