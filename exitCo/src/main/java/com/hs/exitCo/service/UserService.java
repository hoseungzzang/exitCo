package com.hs.exitCo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hs.exitCo.model.User;
import com.hs.exitCo.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void join(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
}
