package com.digitalbooks.service;

import com.digitalbooks.models.Book;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;



public interface BookService {
	
	Book createBook(Book book);
	
	BookRespPayload updateBook(int autherId,int bookId,BookCreaPayload bookUpdate) ;
	
	Book getBookById(int bookId);
	

}
