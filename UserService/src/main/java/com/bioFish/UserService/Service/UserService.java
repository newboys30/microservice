package com.bioFish.UserService.Service;

import java.util.Map;

import com.bioFish.Entity.User;

public interface UserService {
	
	public String getUserById (String str) throws Exception;
	
	public String findAllUser() throws Exception;
	
	public void deleteUser(String str) throws Exception;
	
	public void saveUser(String str) throws Exception;
	
	public void updateUser(String str) throws Exception;
	
	public void redisTest() throws Exception;
	
	public void kafkaTest() throws Exception;
	
	/**
	 * 注册用户
	 * @Title: registUser
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: int
	 */
	public Map<String,Object> registUser(User user) throws Exception;
}
