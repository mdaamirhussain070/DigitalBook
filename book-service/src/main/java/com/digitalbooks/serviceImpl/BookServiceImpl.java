package com.digitalbooks.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.models.Book;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.service.BookService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

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

}
