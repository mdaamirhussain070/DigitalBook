package com.digitalbooks.authorservice;

import org.springframework.http.ResponseEntity;
import com.digitalbooks.payload.request.BookSubscribeRequest;
import com.digitalbooks.payload.response.BookSubscribeResponse;

public interface ReaderService {
	
	ResponseEntity<?> subscribeBook(BookSubscribeRequest subscribeBook );

}
