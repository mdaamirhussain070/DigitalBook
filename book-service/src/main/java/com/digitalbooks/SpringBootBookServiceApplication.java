package com.digitalbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookServiceApplication.class, args);
		System.out.println("Running book service ");
	}

}
