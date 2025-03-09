package com.project.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user_service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	public User findByUsername(String username);
	//Optional<User> findByEmail(String email);
	//Optional<User> findByUsername(String username);
}