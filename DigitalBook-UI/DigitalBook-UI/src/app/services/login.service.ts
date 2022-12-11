import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



const AUTH_API="http://localhost:8081/digitalbooks/";
  const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })

  };
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor( public http:HttpClient) { }


  

  loginUser(username: string,email:string, password: string):Observable<any>{

    
    return this.http.post(AUTH_API+"signin",{
      username,
      email,
      password
    },httpOptions);

  }
}
