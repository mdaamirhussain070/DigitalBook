package com.digitalbooks.controllers;

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
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.service.BookService;
import com.digitalbooks.utility.BookStatus;

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

}
