import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { TokenStorageService } from './token-storage.service';
const status_API="http://localhost:8081/digitalbooks/subscribe/"

@Injectable({
  providedIn: 'root'
})
export class BooksubscribeService {

  constructor(public http:HttpClient, public localStorageToken:TokenStorageService) { }


  subscribeBookService( bookId:number,authorId:number):Observable<any>{
    const token_key=this.localStorageToken.getToken();
    console.log(token_key);
    const httpOptions = new HttpHeaders({
     'Content-Type': 'application/json',
     Authorization: `Bearer `+ token_key
   });
  
   return this.http.post(status_API,{bookId,authorId},{headers:httpOptions})

  }
}
