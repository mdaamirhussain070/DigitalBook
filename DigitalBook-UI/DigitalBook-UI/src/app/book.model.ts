export class Book {
  [x: string]: any;

   

    public id:number;
    public title:string;
    public code:number;
    public autherId:number;
    public category:string;
    public price:number;
    public publisher:string;
    public publishedDate:string;
    public active:boolean;
    public updatedOn:string;

    constructor(id?:number,title?:string,code?:number,autherId?:number,
        category?:string,price?:number,publisher?:string,publishedDate?:string,
        active?:boolean,updatedOn?:string){
            this.id=id || 0;
            this.title=title ||"",
            this.code=code ||0,
            this.autherId=autherId || 0,
            this.category=category ||"",
            this.price=price|| 0,
            this.publisher=publisher||"",
            this.publishedDate=publishedDate|| "",
            this.active=active || false,
            this.updatedOn=updatedOn || ""
        }
        
        get Id():number{
            return this.id as number;
        }
        get Title():string{
            return this.title as string;
        }
        get Code():number{
            return this.code as number;
        }
        get AutherId():number{
            return this.autherId as number;
        }
        get Category():string{
            return this.category as string;
        }
        get Price():number{
            return this.price as number;
        }

        get Publisher():string{
            return this.publisher as string;
        }
        get PublishedDate():string{
            return this.publishedDate as string;
        }
       
        get isActive():boolean{
            return this.active as boolean;
        }
        get upDatedOn():string{
            return this.updatedOn as string;
        }
}
