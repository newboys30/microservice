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
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_company() {
		return user_company;
	}
	public void setUser_company(String user_company) {
		this.user_company = user_company;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
}
