package com.bioFish.DAOService.Execute.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bioFish.DAOService.DaoSupport.DaoSupport;
import com.bioFish.DAOService.DataSource.ReadDataSource;
import com.bioFish.DAOService.util.SpringContextUtil;
import com.bioFish.Entity.User;
import com.bioFish.Entity.User_Roles_Resource.User_Role;
import com.bioFish.Utils.JsonUtil;

/**
 * 用户权限通用类
 * @ClassName: UserRoleExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月7日 上午12:03:24
 */
@Service("userroleExecute")
public class UserRoleExecute {
	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * 根据用户id获取用户权限
	 * @Title: getUserRoleByUserId
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: User_Role
	 */
	@ReadDataSource
	public User_Role getUserRoleByUserId(String jsonStr) throws Exception{
		String user_Id = JsonUtil.changeGsonToBean(jsonStr, String.class);
		User user = this.getExecute().getUserByUserId(user_Id);
		
		if(null == user)
			return null;
		//String user_Name = user.
		//return new User_Role(user_Id, user_Name, roles);
		return null;
	}
	
	/**
	 * 通过UserId查找User信息
	 * @Title: getUserByUserId
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: User
	 */
	@ReadDataSource
	private User getUserByUserId(String user_id) throws Exception{
		return (User) dao.findForObject("UserMapper.selectById", user_id);
	}
	
	/**
	 * 内部调用触发AOP拦截
	 * @Title: getExecute
	 * @Description: TODO
	 * @return
	 * @return: UserRoleExecute
	 */
	private UserRoleExecute getExecute() {
		return SpringContextUtil.getBean(this.getClass());
	}
}
