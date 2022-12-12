import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit, Optional } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { BookCreRequest } from '../book-cre-request.model';
import { TokenStorageService } from './token-storage.service';

const CreateBook_API="http://localhost:8081/digitalbooks/author/books";
  




@Injectable({
  providedIn: 'root'
})
export class CeatebookService implements OnInit {


  constructor( public http:HttpClient, public localStorageToken:TokenStorageService) { }
 
 
  ngOnInit(): void {
    
  }
  

  createBookService(_createBookReq:BookCreRequest):Observable<any>{
    const token_key=this.localStorageToken.getToken();
    console.log(token_key);
    const httpOptions = new HttpHeaders({
     'Content-Type': 'application/json',
     Authorization: `Bearer `+ token_key
   });
  

    return this.http.post(CreateBook_API,_createBookReq,{headers:httpOptions})

  }
}


