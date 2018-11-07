package com.bioFish.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 角色信息
 * @ClassName: Role
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月7日 上午11:16:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Role {
	private String role_Id;
	private String role_Name;
	private String role_description;
}
