package com.digitalbooks.authorserviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.authorservice.AuthorService;
import com.digitalbooks.models.Book;
import com.digitalbooks.payload.request.BookCreaPayload;
import com.digitalbooks.payload.response.BookRespPayload;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Override
	public BookRespPayload createBook(BookCreaPayload bookcreatepayload) {
		
		RestTemplate resttemp=new RestTemplate();
	
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Long authorId=user.getId();
		Long authorId=1L;
		System.out.println(authorId);
		
		String url="http://localhost:8085/digitalbooks/author/"+authorId+"/book";
		
		BookRespPayload bokresp=resttemp.postForObject(url,bookcreatepayload, BookRespPayload.class);
		System.out.println(" rest template executed");
		
		return bokresp;
	}

	@Override
	public List<Book> getAllBooks(String title, String author, double price, String publisher) {
		
		
		
		RestTemplate resttemp=new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		String url="http://localhost:8085/digitalbooks/";
		List<Book> books= resttemp.getForObject(url, List.class);
	
		List<Book> bookjava=new ArrayList<>();
		
		for(int i=0;i<books.size();i++) {
			Book b=objectMapper.convertValue(books.get(i),Book.class);
			bookjava.add(b);
		}
		if(title!=null) {
		return bookjava.stream()
			.filter((t)->t.getTitle().equalsIgnoreCase(title))
			.collect(Collectors.toList());
			
		//	return bookWithTitle;
		}
//		if(price==0) {
//			List<Book> bookWithPrice= books.stream()
//				.filter((t)->t.getPrice()==price)
//				.collect(Collectors.toList());
//			return bookWithPrice;
//			}
////		if(author==null) {
////			List<Book> bookWithAuthor= books.stream()
////				.filter((t)->t.getAutherId())
////				.collect(Collectors.toList());
////			return bookWithAuthor;
////			}
//		
//		if(publisher==null) {
//			List<Book> bookWithPublisher= books.stream()
//				.filter((t)->t.getPublisher().equalsIgnoreCase(publisher))
//				.collect(Collectors.toList());
//				
//				return bookWithPublisher;
//			}
//		
		
		return books;
	}
	
	

}
