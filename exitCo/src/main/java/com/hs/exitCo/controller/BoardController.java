package com.hs.exitCo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

	
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		
		return "board/saveForm";
	}
	
	@GetMapping("/auth/board/comuSearch/{title}")
	public String comuSearch(@PathVariable String title) {
		System.out.println(title);
		return "board/community";
	}
}
