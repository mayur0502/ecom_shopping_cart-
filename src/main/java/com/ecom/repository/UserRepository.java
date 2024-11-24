package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.UserDls;

public interface UserRepository extends JpaRepository<UserDls, Integer> {
		
	public UserDls findByEmail(String email);
		
	
}
