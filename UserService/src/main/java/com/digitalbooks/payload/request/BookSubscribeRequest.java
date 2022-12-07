package com.digitalbooks.payload.request;

public class BookSubscribeRequest {

	private long bookId;
	private long authorId;
	
	public BookSubscribeRequest(long bookId, long authorId) {
		super();
		this.bookId = bookId;
		this.authorId = authorId;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
}
