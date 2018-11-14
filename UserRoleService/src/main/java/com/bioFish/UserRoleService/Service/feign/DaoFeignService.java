package com.bioFish.UserRoleService.Service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("daoservice")
public interface DaoFeignService {
	@RequestMapping(value = "/generel")
	public String generel (@RequestParam("jsonStr") String jsonStr);
}
