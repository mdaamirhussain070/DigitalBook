package com.digitalbooks.serviceImpl;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.models.Book;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository; 

	@Override
	public Book createBook(Book book) {
		
//		if(this.bookRepository.existsById(book.getId())) {
//		//	throw new Exception();
//		}
//		else if(this.bookRepository.findByCode(null))
		
		
		Book createdBook=this.bookRepository.save(book);
		return createdBook;
	}

	@Override
	public BookRespPayload updateBook(int autherId, int bookId, BookCreaPayload bookUpdate) {
		
		Optional<Book> book=bookRepository.findById(bookId);
		
		if(book.isPresent()) {
			if(autherId==book.get().getAutherId()) {
			
			book.get().setTitle(bookUpdate.getTitle());
			book.get().setCategory(bookUpdate.getCategory());
			book.get().setActive(bookUpdate.isActive());
			book.get().setPrice(bookUpdate.getPrice());
			book.get().setBookcontent(bookUpdate.getBookcontent());
			book.get().setUpdatedOn(LocalDateTime.now());
			book.get().setCode(bookUpdate.getCode());
			book.get().setPublisher(bookUpdate.getPublisher());
			
			Book updatedBook=bookRepository.save(book.get());
			BookRespPayload resp=new BookRespPayload();
			resp.setTitle(updatedBook.getTitle());
			resp.setAuthorId(updatedBook.getAutherId());
			resp.setCategory(updatedBook.getCategory());
			resp.setCode(updatedBook.getCode());
			resp.setPrice(updatedBook.getPrice());
			resp.setBookcontent(updatedBook.getBookcontent());
			resp.setActive(updatedBook.isActive());
			resp.setPublisher(updatedBook.getPublisher());
			
			return resp;
			}
			
		}
		return null;
	}

	@Override
	public Book getBookById(int bookId) {
		
		
		return null;
	}

}
