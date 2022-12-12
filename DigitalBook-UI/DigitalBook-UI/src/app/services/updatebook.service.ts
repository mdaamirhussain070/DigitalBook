import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { BookCreRequest } from '../book-cre-request.model';
import { TokenStorageService } from './token-storage.service';

const updateBook_API="http://localhost:8081/digitalbooks/author/books/"
@Injectable({
  providedIn: 'root'
})
export class UpdatebookService {

  constructor(public http:HttpClient, public localStorageToken:TokenStorageService) { }


  updateBookServ(_createBookReq:BookCreRequest,_bookId:number):Observable<any>{
    console.log(_bookId);
    const token_key=this.localStorageToken.getToken();
    console.log(token_key);
    const httpOptions = new HttpHeaders({
     'Content-Type': 'application/json',
     Authorization: `Bearer `+ token_key
   });
  

    return this.http.put(updateBook_API+_bookId,_createBookReq,{headers:httpOptions})

  }
}
