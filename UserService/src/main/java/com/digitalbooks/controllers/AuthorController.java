package com.digitalbooks.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.utility.ApiResponse;
import com.digitalbooks.utility.BookUpdateResponse;

import javassist.expr.NewArray;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/digitalbooks/")
public class AuthorController {
	
	@Autowired
	private UserRepository userRepository;

	RestTemplate restTemplate=new RestTemplate();
	@PostMapping("/author/books")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<BookRespPayload> createBook(@RequestBody BookCreaPayload bookCreatePayload){
		
	

	
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username="";
		if (principal instanceof UserDetails) {
		username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
	
		log.info(username);

		Optional<User> userlogedin=userRepository.findByUsername(username);
		long id=0;
		log.info("Default id="+id);
		if(userlogedin.isPresent()) {
			String user=userlogedin.get().getUsername();
			id=userlogedin.get().getId();
			log.info(user);
			
		}
			
		log.info("Recived author Id from SecurityContextHolder");

		String url = "http://localhost:8085/digitalbooks/author/"+id+"/books";
		log.info("url for create book"+ url);
		restTemplate.postForEntity(url, bookCreatePayload, BookRespPayload.class);
		log.info("Book Creation successfull");
	
	    return new ResponseEntity<BookRespPayload>(HttpStatus.CREATED);
	}
	
	@PutMapping("/author/books/{book-id}")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<BookUpdateResponse> updateBook(@PathVariable("book-id") int bookId,@RequestBody BookCreaPayload bookpayload){
		

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username="";
		if (principal instanceof UserDetails) {
		username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
	
		log.info(username);

		Optional<User> userlogedin=userRepository.findByUsername(username);
		long id=0;
		log.info("Default id="+id);
		if(userlogedin.isPresent()) {
			String user=userlogedin.get().getUsername();
			id=userlogedin.get().getId();
			log.info(user);
			
		}
			
		log.info("Recived author Id from SecurityContextHolder");
		String url="http://localhost:8085/digitalbooks/author/"+id+"/books/"+bookId;
	
		log.info(url);
		
		restTemplate.put(url,bookpayload);
		log.info("Rest template invocked");
		
		return new ResponseEntity<BookUpdateResponse>(new BookUpdateResponse("Book Updated Succefully !","BookID",bookId),HttpStatus.OK);
		
	}
//	/api/v1/digitalbooks/author/{author-id}/books/{book-id}?block=yes
	@PostMapping("/digitalbooks/author/books/{book-id}")
	public ResponseEntity<BookUpdateResponse> changeBookStatus(@PathVariable("book-id") int bookId,@RequestParam(required = true) String status){
	
		if(status.equalsIgnoreCase("YES") || status.equalsIgnoreCase("NO")) {
			
		}
		
		return 
	}
	
	
}
