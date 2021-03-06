package com.bioFish.Entity.User_Roles_Resource;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户角色
 * @ClassName: User_Role
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 上午11:24:23
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class User_Role {
	private Long user_Id;
	private String user_Name;
	List<Role_Resource> roles;
}
