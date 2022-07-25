package com.hs.exitCo.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hs.exitCo.model.Board;



//DAO
//자동으로 bean으로 등록이 된다.
public interface BoardRepository extends JpaRepository<Board,Integer> {



	@Query("SELECT b FROM Board b WHERE b.exitName = :exitName")
	Page<Board> findByExitName(Pageable pageable, String exitName);
 }
