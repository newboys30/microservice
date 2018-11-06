package com.bioFish.LoginService.Service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * redisFeign请求接口
 * @ClassName: RedisFeignService
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 下午6:11:22
 */
@FeignClient("redisservice")
public interface RedisFeignService {
	
}
