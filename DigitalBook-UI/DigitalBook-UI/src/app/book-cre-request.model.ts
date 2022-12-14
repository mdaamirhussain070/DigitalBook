export class BookCreRequest {

    public title:string;
    public code:number;
    public category:string;
    public price:number;
    public publisher:string;
    public status:boolean
    public bookcontent:string;
    constructor(title?:string,code?:number,
        category?:string,price?:number,publisher?:string,
        status?:boolean,bookcontent?:string){
            this.title=title ||"",
            this.code=code ||0,
            this.category=category ||"",
            this.price=price|| 0,
            this.publisher=publisher||"",
            this.status=status || false,
            this.bookcontent=bookcontent || ""
        }
        
       
        get Title():string{
            return this.title as string;
        }
        get Code():number{
            return this.code as number;
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
       
        get Status():boolean{
            return this.status as boolean;
        }
        get BookContent():string{
            return this.bookcontent as string;
        }

        set Title(title:string){
            this.title=title;
        }
        set Code(code:number){
            this.code=code;
        }
        set Category(category:string){
            this.category=category;
        }
        set Price(price:number){
            this.price=price;
        }
        set Publisher(publisher:string){
            this.publisher=publisher;
        }
        set Status(status:boolean){
            this.status=status;
        }

        set BookContent(bookcontent:string){
            this.bookcontent=bookcontent;
        }

}
