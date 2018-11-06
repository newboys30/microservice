package com.bioFish.Entity.User_Roles_Resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 资源
 * @ClassName: Resource
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 上午11:27:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Resource {
	private String resource_Id;
	private String resource_Name;
}
