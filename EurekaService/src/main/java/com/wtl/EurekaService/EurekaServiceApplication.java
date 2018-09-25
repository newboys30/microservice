package com.wtl.EurekaService;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableEurekaServer
@EnableZuulProxy
public class EurekaServiceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EurekaServiceApplication.class, args);
	}
}
