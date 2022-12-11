import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginRequest } from 'src/app/login-request.model';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
      constructor(public loginservice:LoginService){

      }
  ngOnInit(): void {
  
  }

  loginForm=new FormGroup({
    username:new FormControl("", [Validators.required,Validators.min(3),Validators.pattern("[a-zA-Z].*")]),
    email:new FormControl("",[Validators.email,Validators.required]),
    password:new FormControl("",[Validators.required,Validators.pattern("[a-zA-Z].*")])

});
loninRequest=new LoginRequest();


login(){

    this.loninRequest.UserName=this.UserName.value;
    this.loninRequest.Emal=this.Email.value;
    this.loninRequest.Password=this.Password.value;
    this.loginservice.loginUser(this.loninRequest).subscribe(resp=>{
      console.log(resp);

      

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
