package com.bioFish.LoginService.Service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bioFish.Params.DAOParam;

/**
 * DAO连接
 * @ClassName: DAOFeignService
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月12日 上午11:24:12
 */
@FeignClient("daoservice")
public interface DAOFeignService {
	@RequestMapping(value = "/generel")
	public String generel (@RequestParam("jsonStr") String jsonStr);
}
