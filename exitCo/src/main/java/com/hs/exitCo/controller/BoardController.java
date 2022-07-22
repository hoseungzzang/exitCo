package com.hs.exitCo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hs.exitCo.model.Board;
import com.hs.exitCo.model.User;
import com.hs.exitCo.repository.BoardRepository;
import com.hs.exitCo.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/board/saveForm")
	public String saveForm( Board board,Model model) {
		String exitName = board.getExitName();
		model.addAttribute("exitName", exitName);
		
		return "board/saveForm";
	}
	
	@GetMapping("/auth/board/comuSearch/{title}")
	public String comuSearch(@PathVariable String title,Model model,@PageableDefault(size=3,sort="id",direction=Sort.Direction.DESC) 
	Pageable pageable) {
		System.out.println(boardService.boardSearch(pageable,title));
		model.addAttribute("exitNameList",boardService.boardSearch(pageable,title));
		return "board/community";
	}
}
