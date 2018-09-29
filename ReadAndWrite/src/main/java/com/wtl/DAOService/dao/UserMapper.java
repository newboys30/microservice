package com.wtl.DAOService.dao;

import org.apache.ibatis.annotations.Select;

import com.wtl.DAOService.Entity.User;

import tk.mybatis.mapper.common.MySqlMapper;

/**
 * UserMapper
 * @ClassName: UserMapper
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月29日 下午5:04:50
 */
public interface UserMapper extends MySqlMapper<User>{
	
	@Select("select * from t_user where user_name = #{user_name}")
	public User selectByName(String user_name);
}
