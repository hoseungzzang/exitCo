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

	@Transactional
	public void update(User user) {
		User persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원수정 실패: 아이디를 찾을 수 없습니다.");
		});

		System.out.println(user.getPassword().length());
		if (user.getPassword().length() > 0) {
			System.out.println("앙디" + user.getPassword());
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			persistance.setPassword(encPassword);
		}

		persistance.setEmail(user.getEmail());

	}
}
