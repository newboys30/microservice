package com.wtl.DAOService.Execute.impl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wtl.DAOService.Entity.User;
import com.wtl.DAOService.util.DaoSupport;
import com.wtl.Utils.JsonUtil;

public class UserExecute {
	
	@Resource
	private DaoSupport dao;
	
	public String getUser(String user_name) throws Exception{
		User user = (User) dao.findForObject("UserMapper.selectByName", user_name);
		return JsonUtil.createGsonString(user);
	}
	
}
