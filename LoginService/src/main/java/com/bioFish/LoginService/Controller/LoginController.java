package com.bioFish.LoginService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioFish.LoginService.Service.LoginService;

/**
 * 登陆控制器
 * @ClassName: LoginService
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 下午5:19:37
 */
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/testLogin")
	public String testLogin() throws Exception{
		
		return loginService.testKafka();
	}
}
