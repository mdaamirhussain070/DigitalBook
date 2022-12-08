package com.digitalbooks.authorservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.digitalbooks.payload.request.BookReaderContent;
import com.digitalbooks.payload.request.BookSubscribeRequest;



public interface ReaderService {
	
	ResponseEntity<?> subscribeBook(BookSubscribeRequest subscribeBook );
	boolean cancelSubscribeBook(long subscriptionId );
	List<BookReaderContent> getReaderBook();
	BookReaderContent getBookBySubscriptionId(long subscriptionId);
	String getBookContent(long subscriptionId);

}
