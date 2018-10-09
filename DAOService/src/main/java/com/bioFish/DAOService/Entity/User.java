package com.bioFish.DAOService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * USER
 * @ClassName: T_user
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月29日 下午5:01:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
	private Long user_id;
	private String user_name;
	private String user_password;
	private String user_company;
	private String user_role;
}
