package com.digitalbooks.authorservice;

import java.util.List;

import com.digitalbooks.models.Book;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;

public interface AuthorService {
	
	
	BookRespPayload createBook(BookCreaPayload bookcreatepayload);
	
	List<Book> getAllBooks(String title,String author, double price,String publisher);

}
