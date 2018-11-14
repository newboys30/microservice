package com.bioFish.UserRoleService.Service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bioFish.Entity.Role;
import com.bioFish.UserRoleService.Service.UserRoleService;
import com.bioFish.UserRoleService.Service.feign.DaoFeignService;

/**
 * 用户角色实现
 * @ClassName: UserRoleServiceImpl
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月14日 上午11:47:45
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private DaoFeignService daofeignService;
	
	public Map<String,Object> saveRole(Role role) throws Exception{
		
		return null;
	}
}
