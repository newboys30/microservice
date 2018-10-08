package com.bioFish.DAOService.Execute.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bioFish.DAOService.Entity.User;
import com.bioFish.DAOService.Execute.BaseExecute;
import com.bioFish.DAOService.util.DaoSupport;

/**
 * User实际执行类
 * @ClassName: UserExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月8日 下午6:01:41
 */
@Service("userExecute")
public class UserExecute extends BaseExecute{
	
	@Resource
	private DaoSupport dao;
	
	public User getUserByName(String jsonStr) throws Exception{
		String user_name = (String) super.jsonToObject(jsonStr, "String");
		return (User) dao.findForList("UserMapper.selectByName", user_name);
	}
	
	public Map<String,String> insertUser(String jsonStr) throws Exception{
		Map<String,String> retMap = new HashMap<String,String>();
		User user = (User) super.jsonToObject(jsonStr, "User");
		int i = (int) dao.save("UserMapper.saveUser", user);
		
		if(0 != i) {
			retMap.put("retMsg", "保存成功");
			retMap.put("retFlag", "1");
		}else {
			retMap.put("retMsg", "保存失败");
			retMap.put("retFlag", "0");
		}
		return retMap;
	}
}
