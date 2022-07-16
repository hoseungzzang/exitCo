package com.hs.exitCo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hs.exitCo.dto.ResponseDto;
import com.hs.exitCo.model.User;
import com.hs.exitCo.service.UserService;



@RestController
public class UserApiController {
	
	@Autowired
	UserService userService;

	
	@PostMapping("/auth/joinProc")
	public  ResponseDto<Integer> joinProc(@RequestBody User user) {
		userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PostMapping("/auth/loginProc")
	public  ResponseDto<Integer> loginProc(@RequestBody User user) {
		userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
