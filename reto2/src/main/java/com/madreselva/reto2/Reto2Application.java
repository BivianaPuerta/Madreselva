package com.madreselva.reto2;


import org.springframework.boot.CommandLineRunner;

import com.madreselva.reto2.repository.crudRepository.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
	@Autowired
	private UserCrudRepository userCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}


		@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
		//userRepository.save(List.of())
		
	}

}
