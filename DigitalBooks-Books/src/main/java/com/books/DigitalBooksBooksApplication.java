package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class DigitalBooksBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBooksBooksApplication.class, args);
	}

}
