import { ThisReceiver } from "@angular/compiler";

export class JwtResponse {

    public token:string;
    public type:string;
    public id:number;
    public username:string;
    public email:string;
    public roles:string;
    public statusCd: string;
  public statusMsg : string;
  public authStatus : string;

    constructor(token?:string,type?:string,id?:number,username?:string,email?:string,role?:string,
        statusCd?:string,statusMsg?:string,authStatus?:string){
        this.token=token || "",
        this.type=type || "",
        this.id=id || 0,
        this.username=username || "",
        this.email=email || "",
        this.roles=role ||"";
        this.statusCd=statusCd ||"";
        this.statusMsg=statusMsg ||"";
        this.authStatus=authStatus ||"";

    }

    set Token(token:string){
        this.token=token;
    }
    set Type(type:string){
        this.type=type;
    }
    set Id(id:number){
        this.id=id;
    }
    set Username(username:string){
        this.username=username;
    }
    set Email(email:string){
        this.email=email;
    }
    set Role(roles:string){
        this.roles=roles;
    }
    set StatusCd(statusCd:string){
        this.statusCd=statusCd;
    }
    set StatusMsg(statusMsg:string){
        this.statusMsg=statusMsg;
    }
    set AuthStatus(authStatus:string){
        this.authStatus=authStatus;
    }
    get StatusCd():string{
        return this.statusCd;
    }
    get StatusMsg():string{
        return this.statusMsg;
    }
    get AuthStatus():string{
        return this.authStatus;
    }

    get Id():number{
        return this.id as number;
    }
    get Token():string{
        return this.token;
    }
    get Type():string{
        return this.type;
    }
    get Username():string{
        return this.username;
    }
    get Email():string{
        return this.email;
    }
    get Roles():string{
        return this.roles;
    }

}
