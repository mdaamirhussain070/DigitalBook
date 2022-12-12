import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Book } from 'src/app/book.model';
import { HomeService } from 'src/app/services/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

    ngbook : Book[] | undefined;
    isActive:boolean=false;

  constructor(public homeService:HomeService){}
  ngOnInit(): void{
    this.book;
  }
  searchBookForm=new FormGroup({
      title:new FormControl("",[Validators.required]),
      author:new FormControl(""),
      publisher:new FormControl(""),
      price:new FormControl(""),
  });

  book =new Book();
  searBook(){
    console.log(this.searchBookForm.value)
    this.homeService.srearchBook(this.Title.value,this.Author.value,this.Price.value,
      this.publisher.value).subscribe(resp=>{
      this.ngbook =<any>resp;
      if(resp.Id!==0){
        this.isActive=true;
      }
      console.log(resp);
    })


  }
  get Title():FormControl{
    return this.searchBookForm.get("title") as FormControl;
  }
  get Author():FormControl{
    return this.searchBookForm.get("author") as FormControl;
  }
  get publisher():FormControl{
    return this.searchBookForm.get("publisher") as FormControl;
  }
  get Price():FormControl{
    return this.searchBookForm.get("price") as FormControl;
  }

}
