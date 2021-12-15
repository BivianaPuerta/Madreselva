package com.madreselva.reto3;

import com.madreselva.reto3.repository.CrudRepository.OrderCrudRepository;
import com.madreselva.reto3.repository.CrudRepository.ProductsCrudRepository;
import com.madreselva.reto3.repository.CrudRepository.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Reto3Application implements CommandLineRunner {
	@Autowired
	private UserCrudRepository userCrudRepository;
	@Autowired
	private ProductsCrudRepository productsCrudRepository;
	@Autowired
	private OrderCrudRepository orderCrudRepository;


	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
		productsCrudRepository.deleteAll();
		orderCrudRepository.deleteAll();
		//userRepository.save(List.of())
	}

}
