package com.joaozin.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaozin.course.entities.Category;
import com.joaozin.course.entities.Order;
import com.joaozin.course.entities.OrderItem;
import com.joaozin.course.entities.Product;
import com.joaozin.course.entities.User;
import com.joaozin.course.entities.enums.OrderStatus;
import com.joaozin.course.repositories.CategoryRepository;
import com.joaozin.course.repositories.OrderItemRepository;
import com.joaozin.course.repositories.OrderRepository;
import com.joaozin.course.repositories.ProductRepository;
import com.joaozin.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired 
	private OrderItemRepository orderItemRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "The Lord of the rings", "Lorem ipsum dolor sit amer", 150.3, "");
		Product p2 = new Product(null, "Smart TV ", "Nulla em purus. Macenas ante.", 2340.0, "");
		Product p3 = new Product(null, "MacBook Pro", "Nam torto, at mollis  ", 2000.0, "");
		Product p4 = new Product(null, "PC gamer", "Donec aquas odio ac phoncus cursus.  ", 1220.0, "");
		Product p5 = new Product(null, "Ralls for Dummies", "Car fringilla convallis sem vel faucibus  ", 100.0, "");
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		User u = new User(null, "José Aécio", "aecio.diskal@gmail.com", "21999252367", "ppirg22");
		User u2 = new User(null, "Pitoco", "pitoquinho123@gmail.com", "0000023292", "pitoco123");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVIRED, u);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-08-27T12:33:22Z"), OrderStatus.SHIPPED, u);
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		p1.getCategories().add(category2);
		p2.getCategories().add(category1);
		p2.getCategories().add(category3);
		p3.getCategories().add(category3);
		p4.getCategories().add(category3);
		p5.getCategories().add(category2);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		userRepository.saveAll(Arrays.asList(u, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
		OrderItem oi3 = new OrderItem(o2,p3,2,p3.getPrice());
		OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3,p4,p5));
	}

}
