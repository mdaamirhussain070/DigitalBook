package com.digitalbooks.models;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;


@Entity(name="subscribedbook")
@Immutable
public class BookReaderContent {

	@Id
	private int bookId;

	private String title;

	private String bookcontent;

	private String category;

	private String code;
	private String autherId;

	private String price;
	private String publisher;
	private long subscriptionId;

	private long readerId;

	private LocalDateTime dateOfSubscription;
	

	public BookReaderContent() {
		super();
	}


	public int getBookId() {
		return bookId;
	}


	public String getTitle() {
		return title;
	}


	public String getBookcontent() {
		return bookcontent;
	}


	public String getCategory() {
		return category;
	}


	public String getCode() {
		return code;
	}


	public String getAutherId() {
		return autherId;
	}


	public String getPrice() {
		return price;
	}


	public String getPublisher() {
		return publisher;
	}


	public long getSubscriptionId() {
		return subscriptionId;
	}


	public long getReaderId() {
		return readerId;
	}


	public LocalDateTime getDateOfSubscription() {
		return dateOfSubscription;
	}
	


	
	
	

}
