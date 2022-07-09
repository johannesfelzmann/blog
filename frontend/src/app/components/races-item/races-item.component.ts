import { Component, Input, OnInit } from '@angular/core';
import { Post } from 'src/app/dtos/post';
import { FileService } from 'src/app/service/file.service';

@Component({
  selector: 'app-races-item',
  templateUrl: './races-item.component.html',
  styleUrls: ['./races-item.component.scss']
})
export class RacesItemComponent implements OnInit {

  item: Post;
  imgURL: any;

  @Input() set racesItem(item: Post) {
    this.item = item;
    if (item.images.length > 0) {
      const img = FileService.asFile(item.images[0].data, item.images[0].type);
      this.setURL(img);
    }
  }

  constructor() { }
  

  ngOnInit(): void {
  }

    /**
   * Sets the imgURL property (src of img) to the file's temporary URL.
   *
   * @param file the file to be displayed in the img tag
   * @private
   */
     private setURL(file: File) {
      const reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = _event => {
        this.imgURL = reader.result;
      };
    }


}
