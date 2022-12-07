package com.digitalbooks.authorservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.utility.Book;

public interface AuthorService {
	
	
	ResponseEntity<BookRespPayload> createBook(BookCreaPayload bookCreatePayload);
	
	ResponseEntity<BookRespPayload> updateBook(int bookId,BookCreaPayload bookpayload);
	 
	List<Book> getAllBooks(String title,String author, double price,String publisher);
	
	boolean changeBookStatus(int bookId,String status);
	

}
