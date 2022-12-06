package com.digitalbooks.models;

import java.time.LocalDate;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;





public class Book {

	private int id;
	
	@NotBlank
	@Size(max = 150)
	private String title;
	
//	@NotBlank
//	@UniqueElements
//	@Size(min=4 ,max=7)
	private int code;
	
//	@NotBlank
	private int autherId;
	@NotBlank
	@Size(max = 100)
	private String category;

//	@NotBlank
//	@Size(max = 50)
	private double price;
	
	@NotBlank
	@Size(max = 120)
	private String publisher;

	private LocalDate publishedDate;
	
	private LocalDate updatedOn;
	
	private boolean isActive;
	
	
	private String bookcontent;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAutherId() {
		return autherId;
	}

	public void setAutherId(int autherId) {
		this.autherId = autherId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public LocalDate getPudatedOn() {
		return updatedOn;
	}

	public void setPudatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getBookcontent() {
		return bookcontent;
	}

	public void setBookcontent(String bookcontent) {
		this.bookcontent = bookcontent;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", code=" + code + ", autherId=" + autherId + ", category="
				+ category + ", price=" + price + ", publisher=" + publisher + ", publishedDate=" + publishedDate
				+ ", updatedOn=" + updatedOn + ", isActive=" + isActive + ", bookcontent=" + bookcontent + "]";
	}
	
	
	
}
