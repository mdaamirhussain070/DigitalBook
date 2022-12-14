package com.digitalbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.utility.Book;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/digitalbooks/")
public class GlobalController {

///search?category&title&author&price&publisher"
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title,@RequestParam(required = false)
	String author,@RequestParam(required=false ,defaultValue ="0") Integer price,@RequestParam(required=false) String category,@RequestParam(required = false) String publisher){
	
		List<Book> books=authorService.getAllBooks(title, author,category, price, publisher);
		
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	
	
}
