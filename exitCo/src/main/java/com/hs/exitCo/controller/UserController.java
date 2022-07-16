package com.hs.exitCo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/auth/joinForm")
	public String join(Model model) {

		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String login(Model model) {

		return "user/loginForm";
	}
	
	
}
