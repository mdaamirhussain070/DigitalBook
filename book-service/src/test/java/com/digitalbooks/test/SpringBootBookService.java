package com.digitalbooks.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.digitalbooks.models.Book;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { SpringBootBookService.class })
public class SpringBootBookService {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private BookService bookService;
	@MockBean
	private BookRepository bookRepository;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void create_Book_Test() throws Exception {

		Book book = new Book(11, "Hulk", 110, 2, "comic", 50, "marvel", LocalDateTime.now(), LocalDateTime.now(), true,
				"Hulk is comming soon");

		when(bookService.createBook(book)).thenReturn(book);
		ObjectMapper objectMapper = new ObjectMapper();
		String object = objectMapper.writeValueAsString(book);

		mockMvc.perform(post("/digitalbooks/author/11/books").contentType(MediaType.APPLICATION_JSON).content(object)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id").value("11"))

		;
	}

	@Test
	public void getAll_Book_Test() throws Exception {

		Book book1 = new Book(11, "Hulk", 110, 2, "comic", 50, "marvel", LocalDateTime.now(), LocalDateTime.now(), true,
				"Hulk is comming soon");
		Book book2 = new Book(12, "Hulk", 111, 2, "comic", 50, "marvel", LocalDateTime.now(), LocalDateTime.now(), true,
				"Hulk is comming soon");
		List<Book> list=Arrays.asList(book1,book2);
		
		when(bookRepository.findAll()).thenReturn(list);
//		ObjectMapper objectMapper = new ObjectMapper();
//		String object = objectMapper.writeValueAsString(list);

		mockMvc.perform(get("/digitalbooks/")
			//	.contentType(MediaType.APPLICATION_JSON).content(object)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
			//	.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		

		;
	}

}
