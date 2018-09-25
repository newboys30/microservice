package com.wtl.DAOService.Execute.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wtl.DAOService.Entity.T_user;
import com.wtl.DAOService.Repository.UserRepository;
import com.wtl.Utils.JsonUtil;

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
