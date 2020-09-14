package com.shorasul996.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(value = {"com.shorasul996.core.entities"})
@EnableJpaRepositories(value = {"com.shorasul996.core.repositories"})
@SpringBootApplication(scanBasePackages = {"com.shorasul996.web"})
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
