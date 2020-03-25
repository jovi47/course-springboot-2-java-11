package com.joaozin.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaozin.course.entities.Order;
import com.joaozin.course.entities.User;
import com.joaozin.course.entities.enums.OrderStatus;
import com.joaozin.course.repositories.OrderRepository;
import com.joaozin.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u = new User(null, "José Aécio", "aecio.diskal@gmail.com", "21999252367", "ppirg22");
		User u2 = new User(null, "Pitoco", "pitoquinho123@gmail.com", "0000023292", "pitoco123");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.DELIVIRED,u);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.PAID,u2);
		Order o3 = new Order(null, Instant.parse("2019-08-27T12:33:22Z"),OrderStatus.SHIPPED,u);
		userRepository.saveAll(Arrays.asList(u, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}

}
