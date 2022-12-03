package com.digitalbooks.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.models.Book;
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

}
