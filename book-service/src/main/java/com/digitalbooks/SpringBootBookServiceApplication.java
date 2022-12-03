package com.digitalbooks;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookServiceApplication.class, args);
		log.info("Book Service Application Started "+LocalDateTime.now());
	}

}
