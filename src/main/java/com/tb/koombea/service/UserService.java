package com.tb.koombea.service;

import org.springframework.stereotype.Service;

import com.tb.koombea.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	

	

}


