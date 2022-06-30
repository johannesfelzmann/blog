import { Component, Input, OnInit } from '@angular/core';
import { Post } from 'src/app/dtos/post';

@Component({
  selector: 'app-news-item',
  templateUrl: './news-item.component.html',
  styleUrls: ['./news-item.component.scss']
})
export class NewsItemComponent implements OnInit {

  item: Post;

  @Input() set newsItem(item: Post) {
    this.item = item;
  }

  constructor() { }
  

  ngOnInit(): void {
  }

}
