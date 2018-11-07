package com.bioFish.DAOService.Execute.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bioFish.DAOService.DaoSupport.DaoSupport;
import com.bioFish.DAOService.DataSource.ReadDataSource;
import com.bioFish.DAOService.util.SpringContextUtil;
import com.bioFish.Entity.Role;
import com.bioFish.Entity.User;
import com.bioFish.Entity.User_Roles_Resource.Role_Resource;
import com.bioFish.Entity.User_Roles_Resource.User_Role;
import com.bioFish.Entity.User_Roles_Resource.Resources;
import com.bioFish.Utils.JsonUtil;

/**
 * 用户权限通用类
 * @ClassName: UserRoleExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月7日 上午12:03:24
 */
@Service("userroleExecute")
@SuppressWarnings("unchecked")
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
		String user_Name = user.getUser_name();
		return new User_Role(Long.parseLong(user_Id), user_Name, this.getExecute().getRoleResources(user_Id));
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
	 * 根据用户id获取全部权限信息
	 * @Title: Role_Resourcere
	 * @Description: TODO
	 * @throws Exception
	 * @return: void
	 */
	@ReadDataSource
	private List<Role_Resource> getRoleResources(String user_id) throws Exception{
		List<Role_Resource> Role_Resources = new ArrayList<Role_Resource>();
		List<Role> roles = (List<Role>) dao.findForList("UserRoleMapper.findRolesByUserId", user_id);
		if(null == roles)
			return null;
		roles.forEach(role -> {
			String role_id = role.getRole_Id();
			String role_name = role.getRole_Name();
			try {
				Role_Resource role_resource = new Role_Resource(role_id, role_name, this.getExecute().getReSources(role_id));
				Role_Resources.add(role_resource);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return Role_Resources;
	}
	
	/**
	 * 获取资源列表
	 * @Title: getReSources
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: List<Resource>
	 */
	@ReadDataSource
	private List<Resources> getReSources(String role_id) throws Exception{
		return (List<Resources>) dao.findForList("UserRoleMapper.findResourceByRoleId", role_id);
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
