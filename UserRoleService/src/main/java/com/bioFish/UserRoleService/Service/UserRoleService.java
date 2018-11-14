package com.bioFish.UserRoleService.Service;

import java.util.Map;

import com.bioFish.Entity.Role;

/**
 * 用户权限Service
 * @ClassName: UserRoleService
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月14日 下午2:26:40
 */
public interface UserRoleService {
	
	public Map<String,Object> saveRole(Role role) throws Exception;
}
