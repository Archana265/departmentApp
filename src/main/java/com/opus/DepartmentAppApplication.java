package com.opus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DepartmentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentAppApplication.class, args);
	}
}
