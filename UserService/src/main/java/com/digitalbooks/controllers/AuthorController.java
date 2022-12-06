package com.digitalbooks.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.utility.BookUpdateResponse;
import com.digitalbooks.utility.BookStatus;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/digitalbooks/")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	RestTemplate restTemplate=new RestTemplate();
	@PostMapping("/author/books")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<BookRespPayload> createBook(@RequestBody BookCreaPayload bookCreatePayload){
		log.info("Initiating Create Book "+LocalDateTime.now());
		ResponseEntity<BookRespPayload> book=authorService.createBook(bookCreatePayload);
			
		if(book.getStatusCode()==HttpStatus.CREATED) {
			log.info("Book Creation Successfull "+LocalDateTime.now());
			return new ResponseEntity<>(book.getBody(),HttpStatus.CREATED);
		}
		log.info("Book Creation fail "+LocalDateTime.now());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PutMapping("/author/books/{book-id}")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<?> updateBook(@PathVariable("book-id") int bookId,@RequestBody BookCreaPayload bookpayload){
		log.info("Initiating Book Update "+LocalDateTime.now());
		ResponseEntity<BookRespPayload> response=authorService.updateBook(bookId, bookpayload);
		if(response.getStatusCode()==HttpStatus.OK) {
			log.info("Initiating Book Update Successfull "+LocalDateTime.now());
			return new ResponseEntity<BookRespPayload>(response.getBody(),HttpStatus.OK);
		}
		log.info("Initiating Book Update Fail "+LocalDateTime.now());
		return new ResponseEntity<BookUpdateResponse>(new BookUpdateResponse("Book Update Fail !"),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
	@PostMapping("/digitalbooks/author/books/{book-id}")
	@PreAuthorize("hasRole('AUTHOR')")
	ResponseEntity<BookStatus> changeBookStatus(@PathVariable("book-id") int bookId,
			@RequestParam(required = true) String block){
		log.info("Initiating Book Block Or UnBlock "+LocalDateTime.now());
		boolean currentStatus=false;
		if(block.equalsIgnoreCase("YES") || block.equalsIgnoreCase("NO")) {
			currentStatus=authorService.changeBookStatus(bookId, block);
		}
		if(currentStatus) {
			log.info("Initiating Book Block Or UnBlock Successfull "+LocalDateTime.now());
			return new ResponseEntity<>(new BookStatus("Book Status Changed"),HttpStatus.OK); 
		}
		log.info("Initiating Book Block Or Fail "+LocalDateTime.now());
		return new ResponseEntity<>(new BookStatus("Book Block UnBlock Fail"),HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	
}
