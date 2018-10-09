package com.bioFish.DAOService.dao.usermapper;

import org.apache.ibatis.annotations.Mapper;

import com.bioFish.DAOService.Entity.User;

@Mapper
public interface UserMapper {
	public int saveUser(User user);
	public User selectById(int id);
	public User selectByName(String username);
}
