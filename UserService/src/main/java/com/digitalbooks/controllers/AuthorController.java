package com.digitalbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.exceptions.ResourceNotFound;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.utility.ApiResponse;

@RestController
@RequestMapping("/digitalbooks/")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;

	@PostMapping("/author/books")
	public ResponseEntity<BookRespPayload> createBook(@RequestBody BookCreaPayload bookCreatePayload){
		
		BookRespPayload  bookresp=authorService.createBook(bookCreatePayload);
		if(bookresp==null) {
			throw new ResourceNotFound("Not create", "book","Current Book");
		}
	
	    return new ResponseEntity<BookRespPayload>(bookresp,HttpStatus.CREATED);
	}
	
	
}
