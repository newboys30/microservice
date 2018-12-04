package com.bioFish.DAOService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement(order = 10)*/
/**
 * 废弃此思路
 * @ClassName: DaoServiceApplication
 * @Description: TODO
 * @author: newbo
 * @date: 2018年12月3日 下午3:55:13
 */
public class DaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaoServiceApplication.class, args);
	}
}
