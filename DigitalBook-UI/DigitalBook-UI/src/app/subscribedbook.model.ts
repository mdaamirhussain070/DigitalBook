export class Subscribedbook {


    

    public bookId:number;
    public title:string;
    public code:number;
    public autherId:number;
    public category:string;
    public price:number;
    public publisher:string;

    public dateOfSubscription:string;
    public readerId:number;
    public subscriptionId:number

    constructor(bookId?:number,title?:string,code?:number,autherId?:number,
        category?:string,price?:number,publisher?:string
        ,updatedOn?:string,dateOfSubscription?:string,readerId?:number,subscriptionId?:number){
            this.bookId=bookId || 0;
            this.title=title ||"",
            this.code=code ||0,
            this.autherId=autherId || 0,
            this.category=category ||"",
            this.price=price|| 0,
            this.publisher=publisher||"",
            this.dateOfSubscription=dateOfSubscription ||"",
            this.readerId=readerId || 0,
            this.subscriptionId=subscriptionId || 0

        }
        
        get BookId():number{
            return this.bookId as number;
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
        get SubscriptionId():number{
            return this.subscriptionId as number;
        }
        get ReaderId():number{
            return this.autherId as number;
        }
        get DateOfSubscription():string{
            return this.dateOfSubscription as string;
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
       
       
       
        



}
