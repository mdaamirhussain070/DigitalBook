package com.digitalbooks.controllers;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.exceptions.ResourceNotFound;
import com.digitalbooks.models.Book;
import com.digitalbooks.models.BookReaderContent;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.request.BookSubscribe;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.payload.response.BookSubscribeResponse;
import com.digitalbooks.repository.ViewRepository;
import com.digitalbooks.service.BookService;
import com.digitalbooks.utility.BookStatus;
import com.digitalbooks.utility.SubscribeBookProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/digitalbooks/")
public class BookController {

	@Autowired
	private BookService bookService;
	


	@PostMapping("/author/{author-id}/books")
	public ResponseEntity<BookRespPayload> createBook(@Valid @PathVariable("author-id") int authorId,
			@RequestBody BookCreaPayload bookpayload) {

		log.debug("called from User Service");
		BookRespPayload resp = bookService.createBook(authorId, bookpayload);
		return new ResponseEntity<BookRespPayload>(resp, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@PutMapping("/author/{author-id}/books/{book-id}")
	public ResponseEntity<BookRespPayload> updateBook(@PathVariable("author-id") int authorId,
			@PathVariable("book-id") int bookId, @RequestBody BookCreaPayload bookpayload) {

		BookRespPayload updatedBook = bookService.updateBook(authorId, bookId, bookpayload);

		if (updatedBook == null) {
			throw new ResourceNotFound("BOOK NOT FOUND  OR YOU ARE NOT THE AUTHER OF THIS BOOK !", "BookId", bookId);
		}

		return new ResponseEntity<BookRespPayload>(updatedBook, HttpStatus.OK);
	}

	@GetMapping("/book/{book-id}")
	public ResponseEntity<Book> getBookById(@PathVariable("book-id") int bookId) {

		Book book = bookService.getBookById(bookId);
		if (book == null) {
			throw new ResourceNotFound("Book", "BookId", bookId);
		}

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping("/author/{auther-id}/books/{book-id}/status")
	public ResponseEntity<BookStatus> saveBook(@PathVariable("auther-id") int authorId,
			@PathVariable("book-id") int bookId, @RequestParam(required=true) String block, @RequestBody BookStatus bookststus) {

		boolean stsatus = bookService.saveBook(authorId, bookId, block);

		if (!stsatus) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PostMapping("/{reader-id}/subscribe")
	public ResponseEntity<?> subscribeook( @PathVariable("reader-id") int readerId, @RequestBody BookSubscribe bookSubscribeReq){
		
		log.info("Book Subscribe Started "+LocalDateTime.now());
		BookSubscribeResponse subscribebookResp=bookService.subscribeook(bookSubscribeReq,readerId);
		
		if(subscribebookResp==null) {
			log.info("Book Subscribe fail "+LocalDateTime.now());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		log.info("Book Subscribe successfull "+LocalDateTime.now());
		return new ResponseEntity<>(subscribebookResp,HttpStatus.CREATED); 
	}
	
	
	
	@PostMapping("/readers/{reader-id}/books/{subscription-id}/cancel-subscription")
	public ResponseEntity<?> cancelSubscribeBook(@PathVariable("reader-id") long readerId
			,@PathVariable("subscription-id") long subscriptionId,@RequestBody SubscribeBookProxy booksSubs){
		
		log.info("inside canel booksubscription"+LocalDateTime.now());
		boolean status=bookService.cancelSubscribeBook(readerId, subscriptionId);
		
		if(status) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	///api/v1/digitalbooks/readers/{emailId}/books
	
	@GetMapping("/readers/{readerId}/books/{subscription-id}")
	public ResponseEntity<BookReaderContent> getSubscribedBook(@PathVariable("readerId") long readerId,
	@PathVariable("subscription-id") long sbscrId){
	
		BookReaderContent book=bookService.getSubscribedBook(readerId, sbscrId);
		
		return new ResponseEntity<>(book,HttpStatus.OK);
		
	}
	
	@GetMapping("/readers/{readerId}/books")
	public ResponseEntity<List<BookReaderContent>> getReaderBook(@PathVariable("readerId") long readerId){
		
		List<BookReaderContent> readerbook=bookService.getReaderBook(readerId);
		
		return new ResponseEntity<>(readerbook,HttpStatus.OK);
	}
	@GetMapping("/readers/{readerId}/books/{subscription-id}/read")
	public ResponseEntity<String> getBookContent(@PathVariable("readerId") long readerId,
			@PathVariable("subscription-id") long sbscrId){
		
		String bookContent=bookService.getBookContent(readerId, sbscrId);
		
		return new ResponseEntity<>(bookContent.toUpperCase(),HttpStatus.OK);
	}
	
	
}
