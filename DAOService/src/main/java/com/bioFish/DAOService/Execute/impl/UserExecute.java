package com.bioFish.DAOService.Execute.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bioFish.DAOService.Entity.User;
import com.bioFish.DAOService.util.DaoSupport;
import com.bioFish.Utils.JsonUtil;

/**
 * User实际执行类
 * @ClassName: UserExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月8日 下午6:01:41
 */
@Service("userExecute")
public class UserExecute {
	
	@Resource
	private DaoSupport dao;
	
	public String getAllUsers(String user_name) throws Exception{
		List<User> users = (List<User>) dao.findForList("UserMapper.selectByName", user_name);
		return JsonUtil.createGsonString(users);
	}
}
