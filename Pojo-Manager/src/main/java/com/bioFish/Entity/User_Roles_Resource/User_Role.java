package com.bioFish.Entity.User_Roles_Resource;

import java.util.List;

/**
 * 用户角色
 * @ClassName: User_Role
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 上午11:24:23
 */
public class User_Role {
	private Long user_Id;
	private String user_Name;
	List<Role_Resource> roles;
	
	public User_Role(Long user_Id, String user_Name, List<Role_Resource> roles) {
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.roles = roles;
	}
}
