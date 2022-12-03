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




@Entity
@Table(	name = "tbl_book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
//	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name="contentId")
	
	private String bookcontent;
	
	
	

	public Book() {
		super();
	}
	
	

	public Book(int id,String title, int code, int autherId,
			String category, double price, String publisher,
			LocalDate publishedDate, LocalDate updatedOn, boolean isActive, String bookcontent) {
		super();
		this.id = id;
		this.title = title;
		this.code = code;
		this.autherId = autherId;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.updatedOn = updatedOn;
		this.isActive = isActive;
		this.bookcontent = bookcontent;
	}



	public Book(String title,int code,int autherId, String category,double price,String publisher,
			LocalDate publishedDate, LocalDate updatedOn, boolean isActive,String bookcontent) {
		this.title = title;
		this.code = code;
		this.autherId = autherId;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.updatedOn = updatedOn;
		this.isActive = isActive;
		this.bookcontent = bookcontent;
	}
	
	
	
	

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

	public void setPudatedOn(LocalDate pudatedOn) {
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
