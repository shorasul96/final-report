package com.shorasul996.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(value = {"com.shorasul996.core.entities"})
@EnableJpaRepositories(value = {"com.shorasul996.core.repositories"})
@SpringBootApplication(scanBasePackages = {"com.shorasul996.api"})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
