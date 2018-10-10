package com.bioFish.UserService.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioFish.Params.WebParam;
import com.bioFish.UserService.Service.UserService;
import com.bioFish.Utils.JsonUtil;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/getUserById/{id}")
	public String getUserById(@PathVariable Long id) throws Exception {
		return userService.getUserById(id.toString());
	}
	
	@PostMapping("/findAllUsers")
	public String findAllUsers() throws Exception {
		return userService.findAllUser();
	}
	
	@PostMapping("/saveUser")
	public void saveUser() throws Exception {
		Map<String,Object> param = WebParam.changeWebParam(request);
		String str = JsonUtil.createGsonString(param);
		userService.saveUser(str);
	}
	
	@PostMapping("/redisTest")
	public void redisTest() throws Exception {
		userService.redisTest();
	}
	
	@PostMapping("/kafkaTest")
	public void kafkaTest() throws Exception {
		userService.kafkaTest();
	}
	
}
