import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/dtos/post';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {

  posts: Post[] = [];

  constructor(private postService: PostService) { }

  ngOnInit(): void {

    this.postService.getPosts().subscribe(
      response => {
        this.posts = response; //TODO
        console.log(response);
      }, error => {
        console.log(error);
      }
    );

  }

}
