package com.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootJpaPatientServiceAssign4AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaPatientServiceAssign4AppApplication.class, args);
		System.out.println("Patient Service Started");
	}

}
