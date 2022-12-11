export class LoginRequest {

    public username: string;
    public email:string;
    public password: string;

    constructor( username?:string,email?:string,password?:string){
        this.username=username || "",
        this.email=email || "",
        this.password=password ||""
    }
    set UserName(username:string){
        this.username=username;
      }
      set Emal(email:string){
        this.email=email;
      }
      set Password(password:string){
        this.password=password;
      }
}
