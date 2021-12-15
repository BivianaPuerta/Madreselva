package com.madreselva.reto5;

import com.madreselva.reto5.repository.crudRepository.OrderCrudRepository;
import com.madreselva.reto5.repository.crudRepository.ProductsCrudRepository;
import com.madreselva.reto5.repository.crudRepository.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto5Application  implements CommandLineRunner{
	@Autowired
	private UserCrudRepository userCrudRepository;
	@Autowired
	private ProductsCrudRepository productsCrudRepository;
	@Autowired
	private OrderCrudRepository orderCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Reto5Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
		productsCrudRepository.deleteAll();
		orderCrudRepository.deleteAll();
		//userRepository.save(List.of())
	}
}
