package com.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootJpaServiceAssign4AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaServiceAssign4AppApplication.class, args);
		System.out.println("Eureka Server started to register a micro-service");
	}

}