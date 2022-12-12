import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RegistrationService } from 'src/app/registration.service';
import { User } from 'src/app/user.model';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
   result : String='Register First ';
   isAccountCreate: boolean | undefined;
  constructor(public registrationService:RegistrationService){}
  ngOnInit(): void {
    
  }

  registerForm=new FormGroup({
    name:new FormControl("",[Validators.required,Validators.min(3),Validators.pattern("[a-zA-Z].*")]),
    username:new FormControl("",[Validators.required]),
    email:new FormControl("",[Validators.email,Validators.required]),
    password:new FormControl("",[Validators.required]),
    phonenumber:new FormControl("",[Validators.required]),
    role:new FormControl("")

});

//user=new User(this.Name,this.UserName.value,this.Email.value,this.Password.value,this.PhoneNumber.value,this.Role.value)
user =new User();


//user1=JSON.parse(this.user);
registerSumbited(){

this.user.name=this.Name.value;
this.user.username=this.UserName.value;
this.user.email=this.Email.value;
this.user.password=this.Password.value;
this.user.phoneNumber=this.PhoneNumber.value;
this.user.userRole=this.Role.value;
  console.log(this.registerForm.value);
  console.log(this.user);
  this.registrationService.registerUser(this.user).subscribe(resp=>{
    console.log(resp);
    this.result
    if(resp.length!==0){
      this.isAccountCreate=true;
      this.result =<any> resp;
      this.registerForm.reset();
    }else{
      this.result="Registration Fail"
      this.registerForm.reset();
    }
    
  })
  console.log("called Api");
  
}

get Name():FormControl{
  return this.registerForm.get("name") as FormControl;
}
get UserName():FormControl{
  return this.registerForm.get("username") as FormControl;
}
get Email():FormControl{
  return this.registerForm.get("email") as FormControl;
}
get Password():FormControl{
  return this.registerForm.get("password") as FormControl;
}
 get PhoneNumber():FormControl{
 return this.registerForm.get("phonenumber") as FormControl;
}
get Role():FormControl{
  return this.registerForm.get("role") as FormControl;
 }
}
