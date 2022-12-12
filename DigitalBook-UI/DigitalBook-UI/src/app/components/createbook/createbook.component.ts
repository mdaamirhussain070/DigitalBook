import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent {



  createBookForm=new FormGroup({
    title:new FormControl("",[Validators.required]),
    code:new FormControl(""),
    publisher:new FormControl(""),
    category:new FormControl(""),
    content:new FormControl(""),
    price:new FormControl(""),
});

createBook(){
  console.log(this.createBookForm.value);
}

}
