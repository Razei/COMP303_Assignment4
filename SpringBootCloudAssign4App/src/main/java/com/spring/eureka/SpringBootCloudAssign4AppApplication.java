package com.spring.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootCloudAssign4AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudAssign4AppApplication.class, args);
		System.out.println("Spring Boot Eureka Server started at http://localhost:8761");
	}

}
