package com.bioFish.LoginService.Service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * kafka数据总线请求接口
 * @ClassName: KafkaFeignService
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 下午6:10:29
 */
@FeignClient("kafkaservice")
public interface KafkaFeignService {
	
}
