package com.wtl.DAOService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaoServiceApplication.class, args);
	}
}
