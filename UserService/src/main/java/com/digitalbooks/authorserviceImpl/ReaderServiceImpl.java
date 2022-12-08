package com.digitalbooks.authorserviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

import com.digitalbooks.authorservice.ReaderService;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.BookReaderContent;
import com.digitalbooks.payload.request.BookSubscribe;
import com.digitalbooks.payload.request.BookSubscribeRequest;
import com.digitalbooks.payload.response.BookSubscribeResponse;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.utility.SubscribeBookProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReaderServiceImpl implements ReaderService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<?> subscribeBook(BookSubscribeRequest subscribeBook) {
		
		
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
		String readerName="";
		log.info("Default id=" + id);
		if (userlogedin.isPresent()) {
			String user = userlogedin.get().getUsername();
			id = userlogedin.get().getId();
			readerName=userlogedin.get().getName();
			log.info(user);

		}

		log.info("Recived author Id from SecurityContextHolder");

		String url = "http://localhost:8085/digitalbooks/"+id+"/subscribe";
		log.info("url for create book" + url);
		// ResponseEntity<BookRespPayload> response=restTemplate.postForEntity(url,
		// bookCreatePayload, ResponseEntity.class);
		
		BookSubscribe subscribeBookRequest=new BookSubscribe(subscribeBook.getAuthorId(),subscribeBook.getBookId(),readerName);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BookSubscribe> entity = new HttpEntity<BookSubscribe>(subscribeBookRequest, headers);

		ResponseEntity<?> resp = restTemplate.exchange(url, HttpMethod.POST, entity,
				BookSubscribeResponse.class);
		if(resp.getStatusCode()==HttpStatus.BAD_REQUEST) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		log.info("Book Creation successfull");

		return resp;
		
	}

	@Override
	public boolean cancelSubscribeBook(long subscriptionId) {
		
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
		String readerName="";
		log.info("Default id=" + id);
		if (userlogedin.isPresent()) {
			String user = userlogedin.get().getUsername();
			id = userlogedin.get().getId();
			readerName=userlogedin.get().getName();
			log.info(user);

		}

		log.info("Recived author Id from SecurityContextHolder");

	
		
		// ResponseEntity<BookRespPayload> response=restTemplate.postForEntity(url,
		// bookCreatePayload, ResponseEntity.class);
		
		String url=	"http://localhost:8085/digitalbooks/readers/"+id+"/books/"+subscriptionId+"/cancel-subscription";
		SubscribeBookProxy proxyy=new SubscribeBookProxy();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<SubscribeBookProxy> entity = new HttpEntity<SubscribeBookProxy>(proxyy, headers);

		ResponseEntity<?> resp = restTemplate.exchange(url, HttpMethod.POST, entity,
				BookSubscribeResponse.class);
		if(resp.getStatusCode()==HttpStatus.BAD_REQUEST) {
			return false;
		}

		log.info("Book Subscription cancel successfull");
		
		return true;
	}

	@Override
	public List<BookReaderContent> getReaderBook() {
		
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
		String readerName="";
		log.info("Default id=" + id);
		if (userlogedin.isPresent()) {
			String user = userlogedin.get().getUsername();
			id = userlogedin.get().getId();
			readerName=userlogedin.get().getName();
			log.info(user);

		}

		log.info("Recived author Id from SecurityContextHolder");
		
		String url="http://localhost:8085/digitalbooks/readers/"+id+"/books";

		List<BookReaderContent> resp = restTemplate.getForObject(url,List.class );

	
		return resp;
	}
	
	
	
	@Override
	public BookReaderContent getBookBySubscriptionId(long SubscriptionId) {
		
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
		String readerName="";
		log.info("Default id=" + id);
		if (userlogedin.isPresent()) {
			String user = userlogedin.get().getUsername();
			id = userlogedin.get().getId();
			readerName=userlogedin.get().getName();
			log.info(user);

		}

		log.info("Recived author Id from SecurityContextHolder");
		
		String url="http://localhost:8085/digitalbooks/readers/"+id+"/books/"+SubscriptionId;

		BookReaderContent resp = restTemplate.getForObject(url,BookReaderContent.class);

	
		return resp;
	}
	@Override
	public String getBookContent(long subscriptionId) {
		
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
		String readerName="";
		log.info("Default id=" + id);
		if (userlogedin.isPresent()) {
			String user = userlogedin.get().getUsername();
			id = userlogedin.get().getId();
			readerName=userlogedin.get().getName();
			log.info(user);

		}

		log.info("Recived author Id from SecurityContextHolder");

		String url="http://localhost:8085/digitalbooks/readers/"+id+"/books/"+subscriptionId+"/read";
		

		String bookcontent = restTemplate.getForObject(url,String.class);

	
		return bookcontent;
	}
	
	

}
