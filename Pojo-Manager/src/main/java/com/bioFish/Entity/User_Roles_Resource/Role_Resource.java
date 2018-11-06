package com.bioFish.Entity.User_Roles_Resource;

import java.util.List;

/**
 * 角色资源
 * @ClassName: Role_Resource
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 上午11:24:38
 */
public class Role_Resource {
	private String role_Id;
	private String role_name;
	private List<Resource> resources;
	
	public Role_Resource(String role_Id, String role_name, List<Resource> resources) {
		this.role_Id = role_Id;
		this.role_name = role_name;
		this.resources = resources;
	}
}
