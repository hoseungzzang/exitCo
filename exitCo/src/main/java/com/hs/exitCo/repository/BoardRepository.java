package com.hs.exitCo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hs.exitCo.model.Board;
import com.hs.exitCo.model.User;

//DAO
//자동으로 bean으로 등록이 된다.
public interface BoardRepository extends JpaRepository<Board,Integer> {

	

 }
