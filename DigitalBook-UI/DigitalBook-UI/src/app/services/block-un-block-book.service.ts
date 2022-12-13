import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

const status_API="http://localhost:8081/digitalbooks/digitalbooks/author/books/"
@Injectable({
  providedIn: 'root'
})
export class BlockUnBlockBookService {

  constructor(public http:HttpClient, public localStorageToken:TokenStorageService) { }


  blockBookService( bookId:number,bookStatus:string):Observable<any>{
    const token_key=this.localStorageToken.getToken();
    console.log(token_key);
    const httpOptions = new HttpHeaders({
     'Content-Type': 'application/json',
     Authorization: `Bearer `+ token_key
   });
  
   return this.http.post(status_API+bookId+"?block="+bookStatus,null,{headers:httpOptions})

  }
}
