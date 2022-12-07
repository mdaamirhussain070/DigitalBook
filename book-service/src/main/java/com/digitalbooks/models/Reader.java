package com.digitalbooks.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_READER")
public class Reader {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="READER_ID")
	
	private long readerId;
	@Column(name="AUTHOR_ID")
	private long authorId;
	
	@Column(name="BOOK_ID")
	private long bookId;
	
	
	@Column(name="DATE_OF_SUBSCRIPTION")
	private LocalDateTime dateOfSubcription;
	
	@Column(name="SUBSCRIBER_NAME")
	private String subscriberName;
	
	@Column(name="UpDATED_ON")
	private LocalDateTime updatedOn;
	
	
	

	public Reader() {
		super();
	}

	public Reader(long authorId,long readerId, long bookId, LocalDateTime dateOfSubcription,
			String subscriberName, LocalDateTime updatedOn) {
		this.readerId = readerId;
		this.authorId=authorId;
		this.bookId = bookId;
		this.dateOfSubcription = dateOfSubcription;
		this.subscriberName = subscriberName;
		this.updatedOn = updatedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReaderId() {
		return readerId;
	}

	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public LocalDateTime getDateOfSubcription() {
		return dateOfSubcription;
	}

	public void setDateOfSubcription(LocalDateTime dateOfSubcription) {
		this.dateOfSubcription = dateOfSubcription;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	
	
}
