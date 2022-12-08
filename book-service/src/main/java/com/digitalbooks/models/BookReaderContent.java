package com.digitalbooks.models;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBookcontent() {
		return bookcontent;
	}

	public void setBookcontent(String bookcontent) {
		this.bookcontent = bookcontent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAutherId() {
		return autherId;
	}

	public void setAutherId(String autherId) {
		this.autherId = autherId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public long getReaderId() {
		return readerId;
	}

	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}

	public LocalDateTime getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(LocalDateTime dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}

	
	
	

}
