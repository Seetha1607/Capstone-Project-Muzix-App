import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RegistrationComponent } from './registration/registration.component';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatMenuModule} from '@angular/material/menu';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { MovieViewComponent } from './movie-view/movie-view.component';
import { RecommendationComponent } from './recommendation/recommendation.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { SafePipe } from './safe.pipe';
import { DashboardComponent } from './dashboard/dashboard.component';
import {MatDialogModule} from '@angular/material/dialog';
import { PlayComponent } from './play/play.component';
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { PosterComponent } from './poster/poster.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { FilterPipe } from './filter.pipe';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RegistrationComponent,
    LoginComponent,
    HomeComponent,
    MovieViewComponent,
    RecommendationComponent,
    FavouriteComponent,
    SafePipe,
    DashboardComponent,
    PlayComponent,
    PosterComponent,
    FilterPipe,
    
     
  ],

  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatMenuModule,
    MatFormFieldModule,
MatDialogModule,
HttpClientModule,
MatSnackBarModule,
MatTooltipModule,MatProgressSpinnerModule

    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
