package com.digitalbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalbooks.models.BookReaderContent;

@Repository
public interface ViewRepository extends JpaRepository<BookReaderContent, Integer>{

	List<BookReaderContent> findAllByReaderId(long readerId);

	BookReaderContent findByReaderIdAndSubscriptionId(long readerId,long subscriptionId);

	@Query(
			value="select s.bookcontent from subscribedbook s where s.reader_id=:readerId and s.subscription_id=:sbscrId ",nativeQuery = true)
	String findByContent(long readerId, long sbscrId);

}
