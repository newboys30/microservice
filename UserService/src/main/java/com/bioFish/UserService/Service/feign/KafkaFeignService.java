package com.bioFish.UserService.Service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("kafkaservice")
public interface KafkaFeignService {
	@RequestMapping(value = "/generelExe")
	public String generelExe (@RequestParam("jsonStr") String jsonStr);
}
