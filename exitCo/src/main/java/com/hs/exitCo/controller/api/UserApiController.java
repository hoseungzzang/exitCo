package com.hs.exitCo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hs.exitCo.model.User;
import com.hs.exitCo.service.UserService;



@Controller
public class UserApiController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/auth/joinProc")
	public String userJoin(@RequestBody User user) {
		
		
		return null;
	}
}
