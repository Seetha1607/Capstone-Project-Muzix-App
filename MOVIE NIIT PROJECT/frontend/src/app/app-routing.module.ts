import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MovieViewComponent } from './movie-view/movie-view.component';
import { PosterComponent } from './poster/poster.component';
import { RecommendationComponent } from './recommendation/recommendation.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {
    path:"",
    component:PosterComponent,
  },
  {path:"home",component:HomeComponent,},
  {path:"login",component:LoginComponent,},
  {path:"register",component:RegistrationComponent},
  {path:"dashboard", canActivate: [AuthGuard],component:DashboardComponent},
  {
    path: "movie-view",
    canActivate: [AuthGuard],
    component: MovieViewComponent
  },
  {
    path: "favourite",
    canActivate: [AuthGuard],
    component: FavouriteComponent
  },
  {path:"register",component:RegistrationComponent},
  {
    path: "recommended",
    component: RecommendationComponent
  },
  
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

