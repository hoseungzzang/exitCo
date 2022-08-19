package com.hs.exitCo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	@GetMapping("/board/saveForm/{title}")
	public String saveForm(Model model,@PathVariable String title) {
		
		model.addAttribute("exitName", title);
		
		return "board/saveForm";
	}
	
	@GetMapping("/auth/board/comuSearch/{title}")
	public String comuSearch(@PathVariable String title,Model model,@PageableDefault(size=5,sort="id",direction=Sort.Direction.DESC) 
	Pageable pageable) {
		Page<Board> boardSearch = boardService.boardSearch(pageable, title);

	model.addAttribute("exitNameList",boardSearch);
		return "board/community";
	}
	
	@GetMapping("/auth/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board",	boardService.boardIdSearch(id));
		return "board/detail";
	}
	
	@GetMapping("/auth/board/{id}/updateForm")
	public String comuUpdate(@PathVariable int id, Model model) {
		model.addAttribute("board",	boardService.boardIdSearch(id));
		return "board/updateForm";
	}
}
