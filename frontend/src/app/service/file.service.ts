import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { CustomFile } from '../dtos/customFile';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  private uri: string = 'http://localhost:8080/post' + '/files';

  constructor(private httpClient: HttpClient) { }

  // ----- CustomFile to File converter ----
  /**
   * Converts a CustomFile object to a File object.
   *
   * @param customFile a CustomFile file.
   * @param type the type of the file, as a MIME type string.
   */
  public static asFile(customFile: CustomFile, type: string): File {
    return this.blobToFile(this.bytesToBlob(this.base64ToArrayBuffer(customFile), type));
  }
  private static base64ToArrayBuffer(base64: any): Uint8Array {
    const binaryString = window.atob(base64);
    const binaryLen = binaryString.length;
    const bytes = new Uint8Array(binaryLen);
    for (let i = 0; i < binaryLen; i++) {
      bytes[i] = binaryString.charCodeAt(i);
    }
    return bytes;
  }
  private static bytesToBlob(bytes: Uint8Array, type: string): Blob {
    return new Blob([bytes], {type});
  }
  private static blobToFile(blob: Blob): File {
    const b: any = blob;
    b.lastModifiedDate = new Date();
    b.name = 'File';
    return b;
  }
  // ----- Converter above -----

  /**
   * Uploads a file to the server.
   *
   * @param file the file to be uploaded to the server.
   */
  upload(file: File): Observable<CustomFile> {
    const formData = new FormData();
    formData.append('file', file);
    return this.httpClient.post<CustomFile>(this.uri, formData);
  }

}
