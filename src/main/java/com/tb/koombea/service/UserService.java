package com.tb.koombea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tb.koombea.model.User;
import com.tb.koombea.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public List<User> userList() {				
		return userRepository.findAll();
	}
	
	
	public User userCreate(User user) {
		
		return userRepository.save(user);
	}
	
	
	public User loginUser(String email, String password) {
		
		//User user = userRepository.findByEmail(email); 
		User user = userRepository.findByEmailAndPassword(email, password); 
		return user;
    }
	

}


