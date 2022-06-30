import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, filter, tap } from 'rxjs/operators';
import { Visual } from '../enum/visual.enum';
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

   /* posts$ = <Observable <CustomResponse>> this.http.get<CustomResponse>(`${this.apiUrl}/post/list`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  save$ = (post: Post) => <Observable <CustomResponse>> this.http.post<CustomResponse>(`${this.apiUrl}/post/save`, post)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  delete$ = (postId: number) => <Observable <CustomResponse>> this.http.delete<CustomResponse>(`${this.apiUrl}/post/delete/${postId}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );*/

  handleError(error: HttpErrorResponse): Observable <never> {
    console.log(error);
    return throwError(() => new Error(`An error occured - Error code: ${error.status}`));
  }
}
