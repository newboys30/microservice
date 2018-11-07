package com.bioFish.Entity.User_Roles_Resource;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色资源
 * @ClassName: Role_Resource
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 上午11:24:38
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Role_Resource {
	private String role_Id;
	private String role_name;
	private List<Resources> resources;
}
