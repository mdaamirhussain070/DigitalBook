export class User {

    public name: string;
    public username: string;
    public email: string;
 public password: string ;
  public phoneNumber: string;
  public userRole: string;

  constructor(name?:string,username?:string,email?:string,userRole?:string,password?:string,
    phoneNumber?:string){
    
        this.name=name || "";
        this.username=username ||"";
        this.email=email ||"",
        this.password=password ||"",
        this.phoneNumber=phoneNumber || "",
        this.userRole=userRole || ""
  }

  set Name(name:string){
    this.name=name;
  }
  set UserName(username:string){
    this.username=username;
  }
  set Email(email:string){
    this.email=email;
  }
  set Password(password:string){
    this.password=password;
  }
  set PhoneNumber(phoneNumber:string){
    this.phoneNumber=phoneNumber;
  }
  set Role(userRole:string){
    this.userRole=userRole;
  }


  
}
