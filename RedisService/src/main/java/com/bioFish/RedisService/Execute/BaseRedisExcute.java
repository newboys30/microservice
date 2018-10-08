package com.bioFish.RedisService.Execute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class BaseRedisExcute {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public ValueOperations<String,Object> getValueOperations() {
		return redisTemplate.opsForValue(); 
	}
}
