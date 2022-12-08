package com.digitalbooks.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalbooks.models.Book;
import com.digitalbooks.models.BookReaderContent;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.request.BookSubscribe;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.payload.response.BookSubscribeResponse;



public interface BookService {
	

	BookRespPayload createBook( int authorId,BookCreaPayload bookpayload);
	
	BookRespPayload updateBook(int autherId,int bookId,BookCreaPayload bookUpdate) ;
	
	Book getBookById(int bookId);
	List<Book> getAllBooks();
	
	Boolean saveBook(int authorId,int bookId,String bookStatus);
	BookSubscribeResponse subscribeook(BookSubscribe bookSubscribe, int readerId);
	
	Boolean cancelSubscribeBook(long readerId ,long subscriptionId);
	
	List<BookReaderContent> getReaderBook(long readerId);
	
	BookReaderContent getSubscribedBook(long readerId,long sbscrId);
	
	String getBookContent(long readerId,long sbscrId);

}
