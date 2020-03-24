package com.joaozin.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaozin.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
}
