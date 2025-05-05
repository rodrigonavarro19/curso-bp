package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Comandos docker:
 * 
 * docker build --build-arg JAR_FILE=build/libs/*.jar -t springio/gs-spring-boot-docker .
 * docker run -p 8080:8080 springio/gs-spring-boot-docker
 */

@SpringBootApplication
@RestController
public class DemoApplication {

  	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
