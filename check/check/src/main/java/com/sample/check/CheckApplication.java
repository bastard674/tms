package com.sample.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sample.check","com.sample.controler","com.sample.repository","com.sample.service","com.sample.entity"})
@EntityScan(basePackages = "com.sample.entity")
@EnableJpaRepositories("com.sample.repository") 
public class CheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckApplication.class, args);
	}

}





