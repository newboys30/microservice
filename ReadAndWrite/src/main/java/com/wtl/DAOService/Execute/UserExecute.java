package com.wtl.DAOService.Execute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wtl.DAOService.dao.UserMapper;

@RestController
public class UserExecute {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/findAllUsers/{user_name}")
	public String getUser(@PathVariable String user_name) {
		return userMapper.selectByName(user_name).toString();
	}
}
