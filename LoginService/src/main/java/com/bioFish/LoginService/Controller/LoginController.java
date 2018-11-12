package com.bioFish.LoginService.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioFish.LoginService.Service.LoginService;
import com.bioFish.Params.WebParam;


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
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/testLogin")
	public String testLogin() throws Exception{
		Map<String,Object> param = WebParam.changeWebParam(request);
		String user_id = param.get("user_id") == null?"":param.get("user_id").toString();
		if("".equals(user_id))
			return "请输入用户id";
		
		return loginService.roleTree(user_id);
	}
	
}
