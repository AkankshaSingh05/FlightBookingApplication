package com.example.FlightBookingApplication.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlightBookingApplication.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestParam String userId, @RequestParam String name,
			@RequestParam double funds) {
		return ResponseEntity.ok("User Created with userId " + UserService.addUser(userId, name, funds));
	}
}