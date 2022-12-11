import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor( public http:HttpClient) { }
  baseServerUrl="http://localhost:8081/digitalbooks/signup"
  
  registerUser( _user: User){
    console.log("Start calling api");
   return this.http.post(this.baseServerUrl,_user,{
    responseType:'text',
    
   });
  
  }
}
