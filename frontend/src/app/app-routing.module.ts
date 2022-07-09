import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPostComponent } from './components/add-post/add-post.component';
import { NewsDetailComponent } from './components/news-detail/news-detail.component';
import { NewsComponent } from './components/news/news.component';
import { RacesDetailComponent } from './components/races-detail/races-detail.component';
import { RacesComponent } from './components/races/races.component';

const routes: Routes = [
  { path: 'news-detail/:id', component: NewsDetailComponent}, 
  { path: 'races-detail/:id', component: RacesDetailComponent}, 
  { path: 'news', component: NewsComponent},
  { path: 'races', component: RacesComponent},
  { path: 'add-news', component: AddPostComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
