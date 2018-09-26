package com.bioFish.KafkaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.bioFish.KafkaService.execute.KafkaDaoSender;

@SpringBootApplication
@EnableEurekaClient
public class KafkaServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(KafkaServiceApplication.class, args);
		
		KafkaDaoSender sender = context.getBean(KafkaDaoSender.class);
		
		for(int i = 0; i < 3; i++) {
			sender.send();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
