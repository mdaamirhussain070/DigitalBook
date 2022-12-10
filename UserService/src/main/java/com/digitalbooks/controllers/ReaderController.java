package com.digitalbooks.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.authorservice.ReaderService;
import com.digitalbooks.payload.request.BookReaderContent;
import com.digitalbooks.payload.request.BookSubscribeRequest;
import com.digitalbooks.payload.response.BookSubscribeResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/digitalbooks/")
public class ReaderController {
	
	@Autowired
	private ReaderService readerService;
	
	@PostMapping("/subscribe/")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<?> subscribeBook(@RequestBody BookSubscribeRequest subscribeBookReq ){
		
		ResponseEntity<BookSubscribeResponse> subscribeResponse=(ResponseEntity<BookSubscribeResponse>) readerService.subscribeBook(subscribeBookReq);
		
		if(subscribeResponse.getStatusCode()==HttpStatus.CREATED) {
			return new ResponseEntity<>(subscribeResponse,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(new InternalError("Reader Already Subscibed Book"),HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/readers/books/{subscription-id}/cancel-subscription/")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<?> cancelBubscribeBook(@PathVariable("subscription-id") long subscriptionId ){
	
		log.info("Inside cancel Book subscription Started"+LocalDateTime.now());
		boolean status=readerService.cancelSubscribeBook(subscriptionId);
		if(status) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/readers/books/")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<List<BookReaderContent>> getReaderBook(){
		log.info("Get all book by Reader started "+LocalDateTime.now());
		
		List<BookReaderContent> readerbook=readerService.getReaderBook();
		
		return new ResponseEntity<>(readerbook,HttpStatus.OK);
	}
	
	@GetMapping("/readers/books/{subscription-id}")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<BookReaderContent> getBookBySubscriptionId(@PathVariable("subscription-id") long subscriptionId){
		log.info("Get all book by Reader started "+LocalDateTime.now());
		
		BookReaderContent readerbook=readerService.getBookBySubscriptionId(subscriptionId);
		
		return new ResponseEntity<>(readerbook,HttpStatus.OK);
	}
	
//	/api/v1/digitalbooks/readers/{emailId}/books/{subscription-id}/read
	@GetMapping("/readers/books/{subscription-id}/read")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<String> getBookContent(@PathVariable("subscription-id") long subscriptionId){
		log.info("Get all book by Reader started "+LocalDateTime.now());
		
		String bookcontent=readerService.getBookContent(subscriptionId);
		if(bookcontent!=null) {
			return new ResponseEntity<>(bookcontent,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
