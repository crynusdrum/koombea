package com.tb.koombea.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tb.koombea.model.User;
import com.tb.koombea.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserRepository userRepository;
	
	
	

	public UserController(UserRepository userRepository) {	
		this.userRepository = userRepository;
	}




	@GetMapping
	public Page<User> itemList() {
		
		Pageable pageable = PageRequest.of(0, 2);
		
		return userRepository.findAll(pageable);
	}



}
