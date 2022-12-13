import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BooksubscribeService } from 'src/app/services/booksubscribe.service';

@Component({
  selector: 'app-booksubscribe',
  templateUrl: './booksubscribe.component.html',
  styleUrls: ['./booksubscribe.component.css']
})
export class BooksubscribeComponent {

  result : String='';
  isUpdated: boolean | undefined;

  constructor(public subscribeBookservice:BooksubscribeService){}

  subscribeBookForm=new FormGroup({
    bookId:new FormControl("",[Validators.required]),
    authorId:new FormControl("",[Validators.required]),
});

subscribeBook(){
  let bookId=this.BookId.value;
  console.log(bookId);
 
  let authorId=this.AuthorId.value;
  console.log(authorId);
  this.subscribeBookservice.subscribeBookService(bookId,authorId).subscribe(respData=>{
    console.log(respData);
    if(respData.statusCodeValue===201){
      this.result="Book Subscribed";
      this.isUpdated=true;
      this.subscribeBookForm.reset();
    }

  });
  
}
get AuthorId(): FormControl{
  return this.subscribeBookForm.get("authorId") as FormControl;
}
get BookId():FormControl{
  return this.subscribeBookForm.get("bookId") as FormControl;
}

}
