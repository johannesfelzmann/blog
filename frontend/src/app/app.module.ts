import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NewsComponent } from './components/news/news.component';
import { NewsItemComponent } from './components/news-item/news-item.component';
import { FooterComponent } from './components/footer/footer.component';
import { NewsDetailComponent } from './components/news-detail/news-detail.component';
import {IvyCarouselModule} from 'angular-responsive-carousel';
import { AddPostComponent } from './components/add-post/add-post.component';
import { RacesComponent } from './components/races/races.component';
import { RacesItemComponent } from './components/races-item/races-item.component';
import { RacesDetailComponent } from './components/races-detail/races-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NewsComponent,
    NewsItemComponent,
    FooterComponent,
    NewsDetailComponent,
    AddPostComponent,
    RacesComponent,
    RacesItemComponent,
    RacesDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    IvyCarouselModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
