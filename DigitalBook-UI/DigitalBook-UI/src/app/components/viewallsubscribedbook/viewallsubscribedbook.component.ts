import { Component, OnInit } from '@angular/core';
import { ViewallsubscribedbookService } from 'src/app/services/viewallsubscribedbook.service';
import { Subscribedbook } from 'src/app/subscribedbook.model';


@Component({
  selector: 'app-viewallsubscribedbook',
  templateUrl: './viewallsubscribedbook.component.html',
  styleUrls: ['./viewallsubscribedbook.component.css']
})
export class ViewallsubscribedbookComponent implements OnInit {

    result:string | undefined;
   value=true;
  ngbook : Subscribedbook[] | undefined;
  subscribe=new Subscribedbook();
  win: any;
  constructor(public viewSubscribedBook:ViewallsubscribedbookService){}
  ngOnInit(): void {
   this.viewSubscribedBook.ViewsubscribeBook().subscribe(responseData=>{
    this.ngbook =<any>responseData;
    console.log(responseData);
   });
    
  }

  read(subscriptionId:number){
      console.log(subscriptionId);
    
      this.viewSubscribedBook.readBook(subscriptionId).subscribe(responseData=>{
      // responseData = JSON.parse(responseData);
      this.result=responseData;
   //   window.open('',<h1>this.result</h1>);
     //   console.log(responseData);
      this.win = window.open('about:blank', '_blank');
     this.win.document.write(this.result);
     this.win.focus();
        this.value=false;
      });
     
  }
  viewData(){
  
  }

}
