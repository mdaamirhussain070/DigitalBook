package com.digitalbooks.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('AUTHER') or hasRole('USER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/reader")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Reader Board.";
	}

	@GetMapping("/auther")
	@PreAuthorize("hasRole('AUTHER')")
	public String adminAccess() {
		return "Auther Board.";
	}
}
