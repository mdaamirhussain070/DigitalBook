package com.digitalbooks.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.models.Book;
import com.digitalbooks.models.BookReaderContent;
import com.digitalbooks.models.Reader;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.request.BookSubscribe;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.payload.response.BookSubscribeResponse;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.repository.ReaderRepository;
import com.digitalbooks.repository.ViewRepository;
import com.digitalbooks.service.BookService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ReaderRepository readerRepository;
	
	@Autowired
	private ViewRepository viewRepository;

	@Override
	public BookRespPayload updateBook(int autherId, int bookId, BookCreaPayload bookUpdate) {

		Optional<Book> book = bookRepository.findById(bookId);

		if (book.isPresent()) {
			if (autherId == book.get().getAutherId()) {

				book.get().setTitle(bookUpdate.getTitle());
				book.get().setCategory(bookUpdate.getCategory());
				book.get().setActive(bookUpdate.isActive());
				book.get().setPrice(bookUpdate.getPrice());
				book.get().setBookcontent(bookUpdate.getBookcontent());
				book.get().setUpdatedOn(LocalDateTime.now());
				book.get().setCode(bookUpdate.getCode());
				book.get().setPublisher(bookUpdate.getPublisher());

				Book updatedBook = bookRepository.save(book.get());
				BookRespPayload resp = new BookRespPayload();
				resp.setTitle(updatedBook.getTitle());
				resp.setAuthorId(updatedBook.getAutherId());
				resp.setCategory(updatedBook.getCategory());
				resp.setCode(updatedBook.getCode());
				resp.setPrice(updatedBook.getPrice());
				resp.setBookcontent(updatedBook.getBookcontent());
				resp.setActive(updatedBook.isActive());
				resp.setPublisher(updatedBook.getPublisher());

				return resp;
			}

		}
		return null;
	}

	@Override
	public Book getBookById(int bookId) {

		Optional<Book> book = bookRepository.findById(bookId);
		if (book.isPresent()) {
			return book.get();
		}
		return null;
	}

	@Override
	public BookRespPayload createBook(int authorId, BookCreaPayload bookpayload) {

		Book book = new Book(bookpayload.getTitle(), bookpayload.getCode(), authorId, bookpayload.getCategory(),
				bookpayload.getPrice(), bookpayload.getPublisher(), LocalDateTime.now(), LocalDateTime.now(), true,
				bookpayload.getBookcontent());
		log.info("Book Object created");
		Book createdBook = this.bookRepository.save(book);

		BookRespPayload resp = new BookRespPayload();
		resp.setTitle(createdBook.getTitle());
		resp.setAuthorId(createdBook.getAutherId());
		resp.setCategory(createdBook.getCategory());
		resp.setCode(createdBook.getCode());
		resp.setPrice(createdBook.getPrice());
		resp.setBookcontent(createdBook.getBookcontent());
		resp.setActive(createdBook.isActive());
		resp.setPublisher(createdBook.getPublisher());

		return resp;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Boolean saveBook(int authorId, int bookId, String bookStatus) {

		Optional<Book> book = bookRepository.findById(bookId);
		if(!bookStatus.equalsIgnoreCase("YES") && (!bookStatus.equalsIgnoreCase("NO"))) {
			return false;
		}
		if (book.isPresent()) {
			if (book.get().getAutherId() == authorId) {
				if (bookStatus.equalsIgnoreCase("YES")) {
					book.get().setUpdatedOn(LocalDateTime.now());
					book.get().setActive(false);
					bookRepository.save(book.get());
					log.info("Book Blocked" + LocalDateTime.now());
				}
				if (bookStatus.equalsIgnoreCase("NO")) {
					book.get().setUpdatedOn(LocalDateTime.now());
					book.get().setActive(true);
					bookRepository.save(book.get());
					log.info("Book Unblocked" + LocalDateTime.now());
				}
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public BookSubscribeResponse subscribeook(BookSubscribe bookSubscribe,int readerId) {
		
		
		List<Reader> readers=readerRepository.findAll();
		List<Reader> reader=readers.stream()
		.filter(s->s.getBookId()==bookSubscribe.getBookId() && s.getReaderId()==readerId && 
		s.getAuthorId()==bookSubscribe.getAuthorId())
		.collect(Collectors.toList());
		if(!reader.isEmpty()) {
			return null;
		}
		
		Reader newReader1=new Reader(bookSubscribe.getAuthorId(),readerId,bookSubscribe.getBookId(),LocalDateTime.now(),
				bookSubscribe.getSubscriberName(),LocalDateTime.now());
		
		
		Reader savedReader=readerRepository.save(newReader1);
		
		BookSubscribeResponse response=new BookSubscribeResponse();
		response.setSubscriberName(savedReader.getSubscriberName());
		response.setBookId(savedReader.getBookId());
		response.setSubscriptionId(savedReader.getId());
		response.setDateOfSubscription(LocalDateTime.now());
		
		return response;
	}

	@Override
	public Boolean cancelSubscribeBook(long readerId, long subscriptionId) {
		
		Optional<Reader> reader=readerRepository.findById(subscriptionId);
		
		
		
		if(reader.isPresent()) {
			int duration=reader.get().getDateOfSubcription().getHour();
			if(duration>24) {
				return false;
			}
			
			if(reader.get().getId()==subscriptionId) {
				readerRepository.deleteById(reader.get().getId());
				return true;
			}
		}
		
		return false;
		}

	@Override
	public List<BookReaderContent> getReaderBook(long readerId) {

		log.info("Repository called");
		List<BookReaderContent> books=viewRepository.findAllByReaderId(readerId);
		log.info("repository execution ended");
		System.out.println(books);
		return books;
	}

	@Override
	public BookReaderContent getSubscribedBook(long readerId, long sbscrId) {
		
		BookReaderContent book=viewRepository.findByReaderIdAndSubscriptionId(readerId, sbscrId);
		
		return book;
	}

	@Override
	public String getBookContent(long readerId, long sbscrId) {
		
		String content=viewRepository.findByContent(readerId, sbscrId);
		return content;
	}
}
