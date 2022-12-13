import { HttpStatusCode } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BlockUnBlockBookService } from 'src/app/services/block-un-block-book.service';

@Component({
  selector: 'app-blockorunblock',
  templateUrl: './blockorunblock.component.html',
  styleUrls: ['./blockorunblock.component.css']
})
export class BlockorunblockComponent {

  result : String='';
  isUpdated: boolean | undefined;

  constructor(public blockunblockService:BlockUnBlockBookService){}

  blockUnblockBookForm=new FormGroup({
    bookId:new FormControl("",[Validators.required]),
    block:new FormControl("",[Validators.required]),
});

blockorUnblock(){
  let bookId=this.BookId.value;
  let bookStatus=this.Block.value;
  this.blockunblockService.blockBookService(bookId,bookStatus).subscribe(respData=>{
    console.log(respData);
    if(respData.resource==="Book Status Changed"){
      this.result="Book Status Updated";
      this.isUpdated=true;
    }

  });
  
}
get Block(): FormControl{
  return this.blockUnblockBookForm.get("block") as FormControl;
}
get BookId():FormControl{
  return this.blockUnblockBookForm.get("bookId") as FormControl;
}

}
