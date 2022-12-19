package com.digitalbooks.models;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;


@Entity(name="subscribedbook")

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


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setBookcontent(String bookcontent) {
		this.bookcontent = bookcontent;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public void setAutherId(String autherId) {
		this.autherId = autherId;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}


	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}


	public void setDateOfSubscription(LocalDateTime dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}
	


	
	
	

}
