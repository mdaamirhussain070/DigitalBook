package com.digitalbooks.authorserviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.models.Book;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

	@Override
	public List<Book> getAllBooks(String title, String author, double price, String publisher) {

		RestTemplate resttemp = new RestTemplate();

		String url = "http://localhost:8085/digitalbooks/";
		List<Book> books = resttemp.getForObject(url, List.class);
		log.info("User Service connected with Book Service Application");
		if (title != null) {
			List<Book> bookList = jsonToJava(books);
			return bookList.stream().filter((t) -> t.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
		}

		if (price != 0) {
			List<Book> bookList = jsonToJava(books);
			List<Book> bookWithPrice = bookList.stream().filter((t) -> t.getPrice() == price)
					.collect(Collectors.toList());
			return bookWithPrice;
		}
//		if(author==null) {
//			List<Book> bookList=jsonToJava(books);
//			List<Book> bookWithAuthor= books.stream()
//				.filter((t)->t.getAutherId())
//				.collect(Collectors.toList());
//			return bookWithAuthor;
//			}

		if (publisher != null) {
			List<Book> bookList = jsonToJava(books);
			List<Book> bookWithPublisher = bookList.stream().filter((t) -> t.getPublisher().equalsIgnoreCase(publisher))
					.collect(Collectors.toList());

			return bookWithPublisher;
		}

		return books;
	}

	public List<Book> jsonToJava(List<Book> books) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		List<Book> bookjava = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			Book b = objectMapper.convertValue(books.get(i), Book.class);
			bookjava.add(b);
		}
		return bookjava;
	}

}
