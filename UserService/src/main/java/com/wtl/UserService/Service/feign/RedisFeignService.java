package com.wtl.UserService.Service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("redisservice")
public interface RedisFeignService {
	@RequestMapping(value = "/stringTest")
	public String stringTest (String jsonStr);
}
