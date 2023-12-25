package com.example.PrimeProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.PrimeProject.AdminReview", "com.example.PrimeProject.Restaurantv1"})
//@EnableJpaRepositories
//@EntityScan
public class PrimeProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(PrimeProjectApplication.class, args);
	}

}
