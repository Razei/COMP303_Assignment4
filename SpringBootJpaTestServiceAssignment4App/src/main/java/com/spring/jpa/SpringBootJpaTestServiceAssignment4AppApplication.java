package com.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootJpaTestServiceAssignment4AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaTestServiceAssignment4AppApplication.class, args);
		System.out.println("Test Service Started");
	}

}
