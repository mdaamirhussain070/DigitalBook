package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.models.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long>{

}
