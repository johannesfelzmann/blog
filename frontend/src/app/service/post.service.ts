import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, filter, tap } from 'rxjs/operators';
import { Category } from '../enum/category.enum';
import { Post } from '../dtos/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private readonly apiUrl = 'http://localhost:8080/post';

  constructor(private http: HttpClient) { }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.apiUrl}/list`);
  }

  getPostById(id: number): Observable<Post> {
    
    return this.http.get<Post>(`${this.apiUrl}/get/` + id);
  }

  savePost(post: Post): Observable<Post> {
    return this.http.post<Post>(`${this.apiUrl}/save`, post);
  }

  handleError(error: HttpErrorResponse): Observable <never> {
    console.log(error);
    return throwError(() => new Error(`An error occured - Error code: ${error.status}`));
  }
}
