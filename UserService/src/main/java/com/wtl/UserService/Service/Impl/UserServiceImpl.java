package com.wtl.UserService.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wtl.Params.DAOParam;
import com.wtl.UserService.Service.UserService;
import com.wtl.UserService.Service.feign.DaoFeignService;
import com.wtl.UserService.Service.feign.KafkaFeignService;
import com.wtl.UserService.Service.feign.RedisFeignService;
import com.wtl.Utils.JsonUtil;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private DaoFeignService daofeignService;
	@Value("${user.DAOServicePath}")
	private String DAOServicePath;
	
	@Autowired
	private RedisFeignService redisFeignService;
	@Value("${user.RedisServicePath}")
	private String RedisServicePath;
	
	@Autowired
	private KafkaFeignService kafkaFeignService;
	@Value("${user.KafkaServicePath}")
	private String KafkaServicePath;
	
	public String getUserById (String str) throws Exception {
		
		return null;
	}
	
	public String findAllUser() throws Exception {
		DAOParam daoParam = new DAOParam();
		daoParam.setFileName("UserExcute");
		daoParam.setMethods("findAllUser");
		return daofeignService.generel(JsonUtil.createGsonString(daoParam));
	}
	
	public void deleteUser(String str) throws Exception {
		
	}
	
	public void saveUser(String str) throws Exception{
		DAOParam daoParam = new DAOParam();
		daoParam.setFileName("UserExcute");
		daoParam.setMethods("saveUser");
		daoParam.setJsonParam(str);
		daofeignService.generel(JsonUtil.createGsonString(daoParam));
	}
	
	public void updateUser(String str) throws Exception {
		
	}
	
	public void redisTest() throws Exception{
		redisFeignService.stringTest("666");
	}
	
	public void kafkaTest() throws Exception{
		kafkaFeignService.generelExe("");
	}
		
}
