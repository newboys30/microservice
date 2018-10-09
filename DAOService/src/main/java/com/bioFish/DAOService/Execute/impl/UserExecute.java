package com.bioFish.DAOService.Execute.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bioFish.DAOService.DataSource.ReadDataSource;
import com.bioFish.DAOService.DataSource.WriteDataSource;
import com.bioFish.DAOService.Entity.User;
import com.bioFish.DAOService.Execute.BaseExecute;
import com.bioFish.DAOService.dao.usermapper.UserMapper;
import com.bioFish.DAOService.util.SpringContextUtil;

/**
 * User实际执行类
 * 数据库操作必须指定数据库
 * @ClassName: UserExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月8日 下午6:01:41
 */
@Service("userExecute")
public class UserExecute extends BaseExecute{
	
	@Autowired
	private UserMapper userMapper;
	
	@ReadDataSource
	public User getUserByName(String jsonStr) throws Exception{
		String user_name = (String) super.jsonToObject(jsonStr, "String");
		return userMapper.selectByName(user_name);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
	@WriteDataSource
	public Map<String,String> insertUser(String jsonStr) throws Exception{
		Map<String,String> retMap = new HashMap<String,String>();
		User user = (User) super.jsonToObject(jsonStr, "User");
		int i = userMapper.saveUser(user);
		if(0 != i) {
			retMap.put("retMsg", "保存成功");
			retMap.put("retFlag", "1");
		}else {
			retMap.put("retMsg", "保存失败");
			retMap.put("retFlag", "0");
		}
		retMap.put("retMsg", "保存成功");
		return retMap;
	}
	
	
	/**
	 * 内部调用触发AOP拦截
	 * @Title: getExecute
	 * @Description: TODO
	 * @return
	 * @return: UserExecute
	 */
	private UserExecute getExecute() {
		return SpringContextUtil.getBean(this.getClass());
	}
}
