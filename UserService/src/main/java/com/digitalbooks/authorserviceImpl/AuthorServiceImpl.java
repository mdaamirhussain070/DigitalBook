package com.digitalbooks.authorserviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.utility.Book;
import com.digitalbooks.utility.BookStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Book> getAllBooks(String title, String author,String category, double price, String publisher) {

		String url = "http://localhost:8085/digitalbooks/";
		List<Book> books = restTemplate.getForObject(url, List.class);
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

	public Book jsonToJavaBook(Book jsonBook) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper.convertValue(jsonBook, Book.class);

	}

	@Override
	public boolean changeBookStatus(int bookId, String block) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		log.info(username);

		Optional<User> userlogedin = userRepository.findByUsername(username);
		long id = 0;
		log.info("Default id=" + id);
		if (userlogedin.isPresent()) {
			String user = userlogedin.get().getUsername();
			id = userlogedin.get().getId();
			log.info(user);
			log.info(user);
			System.out.println(id);
		}

		String url ="http://localhost:8085/digitalbooks/author/"+id+"/books/"+bookId+"/status?block="+block;

	
	
		HttpHeaders headers = new HttpHeaders();
		BookStatus proxyBook=new BookStatus();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BookStatus> entity = new HttpEntity<>(proxyBook, headers);

		ResponseEntity<?> resp = restTemplate.exchange(url, HttpMethod.POST,entity,
				BookRespPayload.class);
		if(resp.getStatusCode()==HttpStatus.OK) {
			return true;
		}

		return false;
	}

	@Override
	public ResponseEntity<BookRespPayload> createBook(BookCreaPayload bookCreatePayload) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		log.info(username);

		Optional<User> userlogedin = userRepository.findByUsername(username);
		long id = 0;
		log.info("Default id=" + id);
		if (userlogedin.isPresent()) {
			String user = userlogedin.get().getUsername();
			id = userlogedin.get().getId();
			log.info(user);

		}

		log.info("Recived author Id from SecurityContextHolder");

		String url = "http://localhost:8085/digitalbooks/author/" + id + "/books";
		log.info("url for create book" + url);
		// ResponseEntity<BookRespPayload> response=restTemplate.postForEntity(url,
		// bookCreatePayload, ResponseEntity.class);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BookCreaPayload> entity = new HttpEntity<BookCreaPayload>(bookCreatePayload, headers);

		ResponseEntity<BookRespPayload> resp = restTemplate.exchange(url, HttpMethod.POST, entity,
				BookRespPayload.class);

		log.info("Book Creation successfull");

		return resp;
	}

	@Override
	public ResponseEntity<BookRespPayload> updateBook(int bookId, BookCreaPayload bookpayload) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username="";
		if (principal instanceof UserDetails) {
		username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
	
		log.info(username);

		Optional<User> userlogedin=userRepository.findByUsername(username);
		long id=0;
		log.info("Default id="+id);
		if(userlogedin.isPresent()) {
			String user=userlogedin.get().getUsername();
			id=userlogedin.get().getId();
			log.info(user);
			
		}
			
		log.info("Recived author Id from SecurityContextHolder");
		String url="http://localhost:8085/digitalbooks/author/"+id+"/books/"+bookId;
	
		log.info(url);
		
	//	restTemplate.put(url,bookpayload);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BookCreaPayload> entity = new HttpEntity<BookCreaPayload>(bookpayload, headers);

		ResponseEntity<BookRespPayload> resp = restTemplate.exchange(url, HttpMethod.PUT, entity,
				BookRespPayload.class);
		log.info("Rest template invocked");
		return resp;
	}

}
