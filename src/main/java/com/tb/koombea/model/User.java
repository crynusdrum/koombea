package com.tb.koombea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data	
@Entity
@Table(name="usr")
public class User{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String username;
	
	private String email;	
	
	private String password;
	
	
	
	

}
