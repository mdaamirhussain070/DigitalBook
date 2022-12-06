package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


//	boolean findByCode(Object object);


	
}
