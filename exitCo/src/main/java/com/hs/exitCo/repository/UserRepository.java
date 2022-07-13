package com.hs.exitCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hs.exitCo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
