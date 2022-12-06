package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.models.Book;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;



public interface BookService {
	

	BookRespPayload createBook( int authorId,BookCreaPayload bookpayload);
	
	BookRespPayload updateBook(int autherId,int bookId,BookCreaPayload bookUpdate) ;
	
	Book getBookById(int bookId);
	List<Book> getAllBooks();
	
	Boolean saveBook(int authorId,int bookId,String bookStatus);
	

}
