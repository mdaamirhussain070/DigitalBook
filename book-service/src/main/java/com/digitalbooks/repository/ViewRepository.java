package com.digitalbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.digitalbooks.models.BookReaderContent;


public interface ViewRepository extends ReadOnlyRepository<BookReaderContent, Integer>{

	List<BookReaderContent> findAllByReaderId(long readerId);

	BookReaderContent findByReaderIdAndSubscriptionId(long readerId,long subscriptionId);

	@Query(
			value="select s.bookcontent from subscribedbook s where s.reader_id=:readerId and s.subscription_id=:sbscrId ",nativeQuery = true)
	String findByContent(long readerId, long sbscrId);

}
