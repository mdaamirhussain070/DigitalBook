import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtResponse } from 'src/app/jwt-response.model';
import { LoginRequest } from 'src/app/login-request.model';
import { LoginService } from 'src/app/services/login.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
      constructor(public loginservice:LoginService,private router: Router,private tokenStorage: TokenStorageService){

      }

      isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  ngOnInit(): void {
  
  }

  loginForm=new FormGroup({
    username:new FormControl("", [Validators.required,Validators.min(3),Validators.pattern("[a-zA-Z].*")]),
    email:new FormControl("",[Validators.email,Validators.required]),
    password:new FormControl("",[Validators.required,Validators.pattern("[a-zA-Z].*")])
    

});
loninRequest=new LoginRequest();
authStatus: string = "";
jwtResponse=new JwtResponse();
login(){

    this.loninRequest.UserName=this.UserName.value;
    let username=this.UserName.value;
    this.loninRequest.Emal=this.Email.value;
    let email=this.Email.value;
    this.loninRequest.Password=this.Password.value;
    let password=this.Password.value;

    this.loginservice.loginUser(username,email,password).subscribe(data=>{
      console.log(data);
   //   window.sessionStorage.setItem("Authorization",resp.headers.get('Authorization')!);
    
   this.tokenStorage.saveToken(data.accessToken);
   this.tokenStorage.saveUser(data);

   this.isLoginFailed = false;
   this.isLoggedIn = true;
   this.roles = this.tokenStorage.getUser().roles;
   if(data.roles[0]==="ROLE_AUTHOR"){
    console.log(data.roles[0]);
    this.jwtResponse.Username=data.username;
    this.roles=data.roles[0];
    this.router.navigate(['authordashboard']);
   }else{
    this.jwtResponse.Username=data.username;
    this.roles=data.roles[0];
    this.router.navigate(['readerdashboard']);
   }

    })  


  console.log(this.UserName.value);
  console.log(this.Email.value);
  console.log(this.Password.value);
    this.loginForm.reset();

}
get UserName():FormControl{
  return this.loginForm.get("username") as FormControl;
}
get Email():FormControl{
  return this.loginForm.get("email") as FormControl;
}
get Password():FormControl{
  return this.loginForm.get("password") as FormControl;
}

}
function getCookie(arg0: string) {
  throw new Error('Function not implemented.');
}

