package com.digitalbooks.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/digitalbooks/")
public class AuthorController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/author/books")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<BookRespPayload> createBook(@RequestBody BookCreaPayload bookCreatePayload){
		
		RestTemplate resttemp = new RestTemplate();

	
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
			String us=userlogedin.get().getUsername();
			System.out.println("Login user"+us);
			long id2=userlogedin.get().getId();
			System.out.println(id2);
			id=userlogedin.get().getId();
			log.info(username);
			
		}
			
		log.info("Recived author Id from SecurityContextHolder");

		String url = "http://localhost:8085/digitalbooks/author/"+id+"/books";
		log.info("url for create book"+ url);
		resttemp.postForEntity(url, bookCreatePayload, BookRespPayload.class);
		log.info("Book Creation successfull");
	
	    return new ResponseEntity<BookRespPayload>(HttpStatus.CREATED);
	}
	
	
}
