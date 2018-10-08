package com.wtl.DAOService.Execute;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wtl.DAOService.Entity.User;
import com.wtl.DAOService.util.DaoSupport;
import com.wtl.Utils.JsonUtil;

@RestController
public class UserExecute {
	
	@Resource
	private DaoSupport dao;
	
	@GetMapping("/findAllUsers/{user_name}")
	public String getUser(@PathVariable String user_name) throws Exception{
		User user = (User) dao.findForObject("UserMapper.selectByName", user_name);
		return JsonUtil.createGsonString(user);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello MyBatis";
	}
}
