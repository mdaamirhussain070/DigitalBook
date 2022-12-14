import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { observable } from 'rxjs';
import { BookCreRequest } from 'src/app/book-cre-request.model';
import { CeatebookService } from 'src/app/services/ceatebook.service';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent {
  [x: string]: any;
  result : String='';
  isAccountCreate: boolean | undefined;

  constructor(private bookService:CeatebookService){}

  createBookForm=new FormGroup({
    title:new FormControl("",[Validators.required]),
    code:new FormControl("",[Validators.required]),
    publisher:new FormControl("",[Validators.required]),
    category:new FormControl("",[Validators.required]),
    bookContent:new FormControl("",[Validators.required]),
    price:new FormControl("",[Validators.required]),
    status:new FormControl("",[Validators.required]),
});

createBookReq=new BookCreRequest();

createBook(){

  console.log("This is data from form")
 
  this.createBookReq.Title=this.Title.value;
  this.createBookReq.Code=this.Code.value;
  this.createBookReq.Price=this.Price.value;
  this.createBookReq.Category=this.Category.value;
  this.createBookReq.Publisher=this.Publisher.value;
  this.createBookReq.Code=this.Code.value;
  this.createBookReq.Status=this.Status.value;
  this.createBookReq.BookContent=this.BookContent.value;

  //this.createBookForm.controls['content'];
 // this.createBookReq.Content=this.BookContent;
 console.log(this.BookContent);


  console.log("Book Request");
  console.log(this.createBookReq);

  console.log(" Calling Create Request")
  this.bookService.createBookService(this.createBookReq).subscribe(repdata=>{
    console.log(repdata)

    if(repdata!==null){
      this.result="Book is Created successfully"
      this.isAccountCreate=true;
      this.createBookForm.reset();
    }
    
  });
  }




get Title():FormControl{
  return this.createBookForm.get("title") as FormControl;
}
get Code():FormControl{
  return this.createBookForm.get("code") as FormControl;
}
get Publisher():FormControl{
  return this.createBookForm.get("publisher") as FormControl;
}
get Category():FormControl{
  return this.createBookForm.get("category") as FormControl;
}
get BookContent():FormControl{
  return this.createBookForm.get("bookContent") as FormControl;
}
get Price():FormControl{
  return this.createBookForm.get("price") as FormControl;
}
get Status():FormControl{
  return this.createBookForm.get("status") as FormControl;
}

}
