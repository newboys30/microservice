package com.bioFish.RedisService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RedisServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisServiceApplication.class, args);
	}
	
}
