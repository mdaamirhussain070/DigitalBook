import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../login-request.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor( public http:HttpClient) { }

  baseServerUrl="http://localhost:8081/digitalbooks/signin";

  loginUser(_loinRequest:LoginRequest){

    return this.http.post(this.baseServerUrl,_loinRequest,{
      responseType:'text'
    });

  }
}
