package com.digitalbooks.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.models.Book;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.request.BookRespPayload;
import com.digitalbooks.service.BookService;



@RestController
@RequestMapping("/digitalbooks/")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// /author/{author-id}/books
	
@PostMapping("/author/{author-id}/books")
public ResponseEntity<BookRespPayload> createBook( @Valid @PathVariable("author-id") int authorId,@RequestBody BookCreaPayload bookpayload){
	
	 LocalDate now = LocalDate.now();  
	
	 System.out.println(bookpayload);
	 
	Book book=new Book(bookpayload.getTitle(),
			bookpayload.getCode(),
			authorId,
			bookpayload.getCategory(),
			bookpayload.getPrice(),
			bookpayload.getPublisher(),
			now,
			now,
			true,
			bookpayload.getBookcontent());
	System.out.println(book);

	Book createdbook=bookService.createBook(book);
	BookRespPayload resp=new BookRespPayload();
	resp.setTitle(createdbook.getTitle());
	resp.setAuthorId(createdbook.getAutherId());
	resp.setCategory(createdbook.getCategory());
	resp.setCode(createdbook.getCode());
	resp.setPrice(createdbook.getPrice());
	resp.setBookcontent(createdbook.getBookcontent());
	resp.setActive(createdbook.isActive());
	resp.setPublisher(createdbook.getPublisher());
	
	
	
	return new ResponseEntity<BookRespPayload>(resp,HttpStatus.CREATED);
}

}
