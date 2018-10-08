package com.bioFish.DAOService.Execute.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bioFish.DAOService.Entity.T_user;
import com.bioFish.DAOService.Repository.UserRepository;
import com.bioFish.Utils.JsonUtil;

/**
 * UserDAO执行器
 * @ClassName: UserExcute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月18日 下午2:30:54
 */
@Service("userExcute")
public class UserExcute {
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser (String jsonStr) throws Exception {
		T_user user = JsonUtil.changeGsonToBean(jsonStr, T_user.class);
		userRepository.save(user);
	}
	
	public void deleteUserById (String jsonStr) throws Exception {
		T_user user = JsonUtil.changeGsonToBean(jsonStr, T_user.class);
		userRepository.delete(user.getUser_id());
	}
	
	public void deleteUser (String jsonStr) throws Exception {
		T_user user = JsonUtil.changeGsonToBean(jsonStr, T_user.class);
		
		userRepository.delete(user);
	}
	
	public void updateUser (String jsonStr) throws Exception {
		T_user user = JsonUtil.changeGsonToBean(jsonStr, T_user.class);
		userRepository.save(user);
	}
	
	public String getUserById (String jsonStr) throws Exception {
		T_user user = JsonUtil.changeGsonToBean(jsonStr, T_user.class);
		T_user ret = userRepository.findOne(user.getUser_id());
		return JsonUtil.createGsonString(ret);
	}
	
	public String findAllUser () throws Exception {
		List<T_user> list = userRepository.findAll();
		return JsonUtil.createGsonString(list);
	}
}
