package com.joaozin.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaozin.course.entities.User;
import com.joaozin.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u = new User(null,"José Aécio","aecio.diskal@gmail.com","21999252367","ppirg22");
		User u2 = new User(null,"Pitoco","pitoquinho123@gmail.com","0000023292","pitoco123");
		userRepository.saveAll(Arrays.asList(u,u2));
	}
	
	
	
}
