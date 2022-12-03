package com.digitalbooks.service;

import com.digitalbooks.models.Book;

import com.digitalbooks.payload.request.BookRespPayload;

public interface BookService {
	
	Book createBook(Book book);

}
