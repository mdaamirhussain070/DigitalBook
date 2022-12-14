import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { observable } from 'rxjs';
import { BookCreRequest } from 'src/app/book-cre-request.model';
import { UpdatebookService } from 'src/app/services/updatebook.service';

@Component({
  selector: 'app-updatebook',
  templateUrl: './updatebook.component.html',
  styleUrls: ['./updatebook.component.css']
})
export class UpdatebookComponent {
[x: string]: any;

  result : String='';
  isAccountCreate: boolean | undefined;

  constructor(public updateBookService: UpdatebookService){}

  updateBookForm=new FormGroup({
    title:new FormControl("",[Validators.required]),
    code:new FormControl("",[Validators.required]),
    publisher:new FormControl("",[Validators.required]),
    category:new FormControl("",[Validators.required]),
    content:new FormControl('content',[Validators.required]),
    price:new FormControl("",[Validators.required]),
    status:new FormControl("",[Validators.required]),
    bookId:new FormControl("",[Validators.required]),
});
createBookReq=new BookCreRequest();

updateBook(){
 // this.updateBookForm.patchValue({content: this['section'].content});
  console.log("This is data from form")
  //console.log(this.createBookForm.value);
  this.createBookReq.Title=this.Title.value;
  this.createBookReq.Code=this.Code.value;
  this.createBookReq.Price=this.Price.value;
  this.createBookReq.Category=this.Category.value;
  this.createBookReq.Publisher=this.Publisher.value;
  this.createBookReq.Code=this.Code.value;
  this.createBookReq.Status=this.Status.value;
  this.createBookReq.BookContent=<any>this.Content.value;
  let bookId=this.BookId.value;
  this.updateBookService.updateBookServ(this.createBookReq,bookId).subscribe(respdata=>{
    console.log(respdata);

    if(respdata!==null){
      this.result="Book Upadted Successfully"
      this.isAccountCreate=true;
      this.updateBookForm.reset();
    }
  });
  
  console.log(this.BookId.value);
  console.log("Book Request");
  console.log(this.createBookReq);
  
}




get Title():FormControl{
  return this.updateBookForm.get("title") as FormControl;
}
get Code():FormControl{
  return this.updateBookForm.get("code") as FormControl;
}
get Publisher():FormControl{
  return this.updateBookForm.get("publisher") as FormControl;
}
get Category():FormControl{
  return this.updateBookForm.get("category") as FormControl;
}
get Content():FormControl{
  return this.updateBookForm.get("content") as FormControl;
}
get Price():FormControl{
  return this.updateBookForm.get("price") as FormControl;
}
get Status():FormControl{
  return this.updateBookForm.get("status") as FormControl;
}

get BookId():FormControl{
  return this.updateBookForm.get("bookId") as FormControl;
}
}
