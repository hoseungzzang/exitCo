package com.hs.exitCo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hs.exitCo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
