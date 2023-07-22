package com.example.centaure.Centaure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
class CentaureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentaureApplication.class, args);
	}

}
