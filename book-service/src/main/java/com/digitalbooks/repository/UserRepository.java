package com.digitalbooks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.models.Book;

@Repository
public interface UserRepository extends JpaRepository<Book, Long> {


	
}
