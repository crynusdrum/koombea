package com.tb.koombea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tb.koombea.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//List<User> findByEmail(String email);
	User findByEmail(String email);

}
