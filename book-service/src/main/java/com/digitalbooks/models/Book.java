package com.digitalbooks.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
@Table(	name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	private String title;
	@NotBlank
	@Size(max = 100)
	private String category;

	@NotBlank
	@Size(max = 50)
	private long price;

	@NotBlank
	@Size(max = 120)
	private String autherName;
	
	@NotBlank
	@Size(max = 120)
	private String publisher;
	
	private LocalDate publishedDate;
	
	private String conten;
	
	private boolean isActive;
	
}
