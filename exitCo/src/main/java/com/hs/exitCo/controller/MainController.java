package com.hs.exitCo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hs.exitCo.dto.KakaoDto;

@Controller
public class MainController {

	@GetMapping({"/",""})
	public String main(Model model) {
		model.addAttribute("model", "dasdasd");
		return "main";
	}
}
