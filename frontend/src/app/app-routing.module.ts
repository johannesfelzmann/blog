import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { AddPostComponent } from './components/add-post/add-post.component';
import { NewsDetailComponent } from './components/news-detail/news-detail.component';
import { NewsComponent } from './components/news/news.component';
import { RacesDetailComponent } from './components/races-detail/races-detail.component';
import { RacesComponent } from './components/races/races.component';
import { TechnicsDetailComponent } from './components/technics-detail/technics-detail.component';
import { TechnicsComponent } from './components/technics/technics.component';

const routes: Routes = [
  { path: 'news-detail/:id', component: NewsDetailComponent}, 
  { path: 'races-detail/:id', component: RacesDetailComponent}, 
  { path: 'technics-detail/:id', component: TechnicsDetailComponent}, 
  { path: 'news', component: NewsComponent},
  { path: 'races', component: RacesComponent},
  { path: 'technics', component: TechnicsComponent},
  { path: 'about', component: AboutComponent},
  { path: 'add-news', component: AddPostComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
