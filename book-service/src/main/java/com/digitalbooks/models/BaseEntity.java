package com.digitalbooks.models;

import java.time.LocalDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	private String publisher;

	private LocalDate publishedDate;
	
	private LocalDate updatedOn;
	
	private boolean isActive;

}
