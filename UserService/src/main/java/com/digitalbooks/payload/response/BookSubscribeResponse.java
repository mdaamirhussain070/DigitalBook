package com.digitalbooks.payload.response;

import java.time.LocalDateTime;

public class BookSubscribeResponse {
	
	private long bookId;
	
	private String subscriberName;
	
	private LocalDateTime dateOfSubscription;
	
	private long subscriptionId;
	
	public BookSubscribeResponse() {
		super();
	}
	

	public BookSubscribeResponse(long bookId, String subscriberName, LocalDateTime dateOfSubscription,
			long subscriptionId) {
		super();
		this.bookId = bookId;
		this.subscriberName = subscriberName;
		this.dateOfSubscription = dateOfSubscription;
		this.subscriptionId = subscriptionId;
	}


	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public LocalDateTime getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(LocalDateTime dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}
	
	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

}
