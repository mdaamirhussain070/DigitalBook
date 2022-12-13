import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { TokenStorageService } from './token-storage.service';

const View_SubscribedBook_Api="http://localhost:8081/digitalbooks/readers/books/";
const Read_SubscribedBook_Api="http://localhost:8081/digitalbooks/readers/books/";
@Injectable({
  providedIn: 'root'
})
export class ViewallsubscribedbookService {

  constructor(public http:HttpClient, public localStorageToken:TokenStorageService) { }


  ViewsubscribeBook():Observable<any>{
    const token_key=this.localStorageToken.getToken();
    console.log(token_key);
    const httpOptions = new HttpHeaders({
     'Content-Type': 'application/json',
     Authorization: `Bearer `+ token_key
   });
  
   return this.http.get(View_SubscribedBook_Api,{headers:httpOptions});
  }
  readBook( _subscriptionId:number):Observable<any>{
    console.log("read Book method called ");
    const token_key=this.localStorageToken.getToken();
    console.log(token_key);
    const httpOptions = new HttpHeaders({
     'Content-Type': 'application/json',
     Authorization: `Bearer `+ token_key

   });
   httpOptions.set('Content-Type', 'text/plain; charset=utf-8')
   console.log("api called");
   return this.http.get(Read_SubscribedBook_Api+_subscriptionId+"/read",{headers:httpOptions, responseType: 'text'});
  
  }
  
}
