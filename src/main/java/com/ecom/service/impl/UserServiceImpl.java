package com.ecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.model.UserDls;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override 
	public UserDls saveUser(UserDls user) {
		user.setRole("ROLE_USER");
	
		System.out.println("User Password ===========> "+user.getPassword());
		String encodePassword = passwordEncoder.encode(user.getPassword());
		System.out.println("encoded Password ==========> "+encodePassword);
		user.setPassword(encodePassword);
		UserDls saveUser = userRepository.save(user);
		return saveUser;
	}

}
