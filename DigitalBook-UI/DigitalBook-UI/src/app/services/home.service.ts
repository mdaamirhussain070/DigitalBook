import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Book } from '../book.model';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(public http:HttpClient) { }
  book =new Book();
  baseServerUrl="http://localhost:8081/digitalbooks/search?";

  srearchBook(_title:string,_author:string,_price:number,_publisher:string){
    console.log("Start calling api")

    return this.http.get<Book>(this.baseServerUrl+_title+_author+_price+_publisher)
  }
}
