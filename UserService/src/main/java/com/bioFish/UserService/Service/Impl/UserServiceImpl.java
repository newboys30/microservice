package com.bioFish.UserService.Service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bioFish.Entity.User;
import com.bioFish.Params.DAOParam;
import com.bioFish.UserService.Service.UserService;
import com.bioFish.UserService.Service.feign.DaoFeignService;
import com.bioFish.UserService.Service.feign.KafkaFeignService;
import com.bioFish.UserService.Service.feign.RedisFeignService;
import com.bioFish.Utils.JsonUtil;

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
		daoParam.setFileName("UserExecute");
		daoParam.setMethods("queryPage");
		Map<String,Object> pageMap = new HashMap<String,Object>();
		pageMap.put("pageNum", "1");
		pageMap.put("pageSize", "20");
		pageMap.put("username", "admin");
		daoParam.setJsonParam(JsonUtil.createGsonString(pageMap));
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
	
	/**
	 * 注册用户
	 * @Title: registUser
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: int
	 */
	public Map<String,Object> registUser(User user) throws Exception{
		DAOParam dao = new DAOParam();
		dao.setFileName("UserExecute");
		dao.setMethods("insertUser");
		dao.setJsonParam(JsonUtil.createGsonString(user));
		
		String retStr = daofeignService.generel(JsonUtil.createGsonString(dao));
		Map<String,Object> retMap = JsonUtil.changeGsonToMaps(retStr);
		return retMap;
	}
}
