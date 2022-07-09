import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomFile } from 'src/app/dtos/customFile';
import { Post } from 'src/app/dtos/post';
import { FileService } from 'src/app/service/file.service';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.scss']
})
export class AddPostComponent implements OnInit {

  addPostForm: FormGroup;
  submitted = false;
  error = false;
  errorMessage = '';
  fileNoImage = false;
  tooManyFiles = false;
  fileTooBig = false;
  success = false;
  files = [];

  post: Post = <Post>{};


  constructor(private formBuilder: FormBuilder, 
              private postService: PostService, 
              private fileService: FileService,
              private router: Router) { }

  ngOnInit(): void {

    this.addPostForm = new FormGroup({});

    this.addPostForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.maxLength(100)]],
      text: ['', [Validators.required, Validators.maxLength(10000)]],
      files: ['']
    });
  }

  addPost() {
    this.submitted = true;

    if (this.addPostForm.valid) {

      this.post.name = this.addPostForm.value.title;
      this.post.text = this.addPostForm.value.text;

      const fileService = this.fileService;
      let count = this.files.length;
      if (count === 0) {
        // Normal post publish without images

        this.postService.savePost(this.post).subscribe(
          () => {
            this.success = true;
            setTimeout(() => {
              this.router.navigate(['/']);
            }, 3000);
          },
          error => {
            this.defaultServiceErrorHandling(error);
          }
        );
      } else {
        this.post.images = [];
        let postImages: CustomFile[] = [];
        // With images
        this.files.forEach(file => {
          fileService.upload(file).subscribe(f => {
            postImages.push(f); //TODO: if image is in db, do not add the same image again
            count--;
            if (count === 0) {
              this.post.images = postImages;
              this.post.name = this.addPostForm.value.title;
              this.post.text = this.addPostForm.value.text;
              console.log(this.post)
              this.postService.savePost(this.post).subscribe(
                () => {
                  this.success = true;
                  setTimeout(() => {
                    this.router.navigate(['/']);
                  }, 3000);
                },
                error => {
                  this.defaultServiceErrorHandling(error);
                }
              );
            }
          },
          error => {
            this.defaultServiceErrorHandling(error);
          });
        });
      }
    }

    this.post.id = null;
    this.post.name = null;
    this.post.text = null;
    this.post.images = null;
    this.post.visual = null;
  }

  onFileChange(event) {
    this.fileNoImage = false;
    this.tooManyFiles = false;
    this.fileTooBig = false;
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      if (!file.type.includes('image')) {
        this.fileNoImage = true;
      } else if (this.files.length >= 10) {
        this.tooManyFiles = true;
      } else if (file.size > 1000000) {
        this.fileTooBig = true;
      } else {
        this.files.push(file);
      }
    }
  }

  removeImage(index) {
    if (index > -1) {
      this.files.splice(index, 1);
    }
  }


  vanishAlert(): void {
    this.error = false;
    this.success = false;
  }

  private defaultServiceErrorHandling(error: any) {
    //console.log(error);
    this.error = true;
    if (typeof error.error === 'object') {
      this.errorMessage = error.error.error;
    } else {
      this.errorMessage = error.error;
    }
  }

}
