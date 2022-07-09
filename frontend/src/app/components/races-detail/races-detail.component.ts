import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from 'src/app/dtos/post';
import { FileService } from 'src/app/service/file.service';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-races-detail',
  templateUrl: './races-detail.component.html',
  styleUrls: ['./races-detail.component.scss']
})
export class RacesDetailComponent implements OnInit {

  postId = 0;
  postItem: Post;
  imgURL = [];

  constructor(private postService: PostService, private actRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.postId = this.actRoute.snapshot.params.id;

    this.postService.getPostById(this.postId).subscribe(
      response => {
        this.postItem = response; //TODO
        console.log(response);

        if (this.postItem.images.length > 0) {
          for (let i = 0; i < this.postItem.images.length; i++) {
            const img = FileService.asFile(this.postItem.images[i].data, this.postItem.images[i].type);
            this.setURL(img, i);
          }

          console.log(this.imgURL);
        }
      }, error => {
        console.log(error);
      }
    );
  }

  private setURL(file: File, id: number) {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = _event => {
      this.imgURL[id] = {path: reader.result};
    };
  }


}
