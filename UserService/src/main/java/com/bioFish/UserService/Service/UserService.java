package com.bioFish.UserService.Service;

public interface UserService {
	
	public String getUserById (String str) throws Exception;
	
	public String findAllUser() throws Exception;
	
	public void deleteUser(String str) throws Exception;
	
	public void saveUser(String str) throws Exception;
	
	public void updateUser(String str) throws Exception;
	
	public void redisTest() throws Exception;
	
	public void kafkaTest() throws Exception;
}
