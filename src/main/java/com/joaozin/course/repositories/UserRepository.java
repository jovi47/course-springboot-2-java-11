package com.joaozin.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaozin.course.entities.User;

// pode mas como ja herda do JPA, nao precisa //@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
}
