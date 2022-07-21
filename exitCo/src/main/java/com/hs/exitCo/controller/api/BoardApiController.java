package com.hs.exitCo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hs.exitCo.dto.ReplySaveRequestDto;
import com.hs.exitCo.dto.ResponseDto;

@Controller
public class BoardApiController {


	
	@PostMapping("/api/board")
	public  ResponseDto<Integer> save() {
		
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
