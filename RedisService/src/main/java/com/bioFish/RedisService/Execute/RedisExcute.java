package com.bioFish.RedisService.Execute;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisExcute extends BaseRedisExcute{
	
	@PostMapping("/stringTest")
	public void stringTest() {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		valueOperations.set("test", "Hello Redis!");
		System.out.println("useRedisDao = " + valueOperations.get("test"));
	}
	
	@PostMapping("/setValue/{key}/{value}")
	public void setValue(@PathVariable String key, @PathVariable String value) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		valueOperations.set(key, value);
	}
	
	@PostMapping("/getValue/{key}")
	public Object getValue(@PathVariable String key) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		return valueOperations.get(key);
	}
	
	@PostMapping("/append/{key}/{value}")
	public void append(@PathVariable String key,@PathVariable String value) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		valueOperations.append(key, value);
	}
	
	@GetMapping("/getValueStartEnd/{key}/{start}/{end}")
	public void getValue(@PathVariable String key,@PathVariable Long start,@PathVariable Long end) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		valueOperations.get(key, start, end);
	}
	
	@PostMapping("/getAndSet/{key}/{value}")
	public Object getandset(@PathVariable String key,@PathVariable String value) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		return valueOperations.getAndSet(key, value);
	}
	
	@PostMapping("/setValueTime/{key}/{value}/{timeout}")
	public void setValue(@PathVariable String key,@PathVariable String value,@PathVariable Long timeout) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		valueOperations.set(key, value, timeout, TimeUnit.MILLISECONDS);
	}
		
	@PostMapping("/size/{key}")
	public Long size(@PathVariable String key) throws Exception{
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		return valueOperations.size(key);
	}
	
	@PostMapping("/multiSet/{map}")
	public void multiSet(@PathVariable Map<String,Object> map) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		valueOperations.multiSet(map);
	}
	
	@PostMapping("/multiGet/{keys}")
	public Object getandset(@PathVariable Collection<String> keys) throws Exception {
		ValueOperations<String, Object> valueOperations = super.getValueOperations();
		return (List<Object>)valueOperations.multiGet(keys);
	}
}
