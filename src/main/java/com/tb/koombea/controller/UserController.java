package com.tb.koombea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tb.koombea.model.User;
import com.tb.koombea.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	

	@GetMapping
	public List<User> userList() {				
		return userService.userList();
	}
	
	/**
	 * As a user, I must be able to register on the platform. For this, it will only be	necessary to enter a username and password.
	 * @param user
	 * @return
	 */
	@PostMapping
	public User userCreate(@RequestBody User user) {
		
		return userService.userCreate(user);
		
	}
	
	
	/**
	 * As a user, I must be able to log into the system using an email and a password
	 * @param email
	 * @param password
	 * @return
	 */
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
		return Optional.ofNullable(userService.loginUser(email, password))
				.map(userObj -> ResponseEntity.ok().body(userObj)) // 200 OK
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not found
    }



}
