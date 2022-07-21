package com.hs.exitCo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hs.exitCo.dto.ReplySaveRequestDto;
import com.hs.exitCo.model.Board;
import com.hs.exitCo.model.User;
import com.hs.exitCo.repository.BoardRepository;
import com.hs.exitCo.repository.ReplyRepository;
import com.hs.exitCo.repository.UserRepository;




@Service
public class BoardService {


	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public void  board(Board board,User user) {
		
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

	@Transactional(readOnly=true)
	public Page<Board> boardSearch(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly=true)
	public Board boardIdSearch(int id){
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
				});
	}
	
	@Transactional
	public void boardDelete(int id){
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void boardUpdate(int id, Board requestBoard){
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
				});
		
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		//해당 함수로 종료 시 트랜잭션 종료, db 업데이트댐
	}
	@Transactional
	public void replySave(ReplySaveRequestDto replySaveRequestDto){
		replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
	}
	
	@Transactional
	public void replyDelete(int replyId){
		replyRepository.deleteById(replyId);
	}
	
	/*
	@Transactional(readOnly=true) // select 시 트랜잭션 시작, 서비스 종료 시 트랜잭션 종료(정합성)
	public User  login(User user) {
			 return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}*/
}
