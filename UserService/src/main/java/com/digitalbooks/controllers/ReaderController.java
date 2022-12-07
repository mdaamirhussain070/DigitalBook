package com.digitalbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.authorservice.ReaderService;
import com.digitalbooks.payload.request.BookSubscribeRequest;
import com.digitalbooks.payload.response.BookSubscribeResponse;

@RestController
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

}
