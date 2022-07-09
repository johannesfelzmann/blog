import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPostComponent } from './components/add-post/add-post.component';
import { NewsDetailComponent } from './components/news-detail/news-detail.component';
import { NewsComponent } from './components/news/news.component';

const routes: Routes = [
  { path: 'news-detail/:id', component: NewsDetailComponent}, 
  { path: 'news', component: NewsComponent},
  { path: 'add-news', component: AddPostComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
