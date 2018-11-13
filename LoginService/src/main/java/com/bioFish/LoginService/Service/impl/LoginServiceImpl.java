package com.bioFish.LoginService.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bioFish.LoginService.Service.LoginService;
import com.bioFish.LoginService.Service.feign.DAOFeignService;
import com.bioFish.LoginService.Service.feign.KafkaFeignService;
import com.bioFish.LoginService.Service.feign.RedisFeignService;
import com.bioFish.Params.DAOParam;
import com.bioFish.Utils.JsonUtil;

/**
 * 登陆实现类
 * @ClassName: LoginServiceImpl
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 下午6:05:18
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private KafkaFeignService kafkaFeignService;
	
	@Autowired
	private RedisFeignService redisFeignService;
	
	@Autowired
	private DAOFeignService daoFeignService;
	
	/**
	 * 测试kafka请求
	 * @Title: testKafka
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public String testKafka() throws Exception{
		return null;
	}
	
	/**
	 * 权限树
	 * @Title: roleTree
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public String roleTree(String user_id) throws Exception{
		DAOParam daoParam = new DAOParam();
		daoParam.setJsonParam(JsonUtil.createGsonString(user_id));
		daoParam.setFileName("UserRoleExecute");
		daoParam.setMethods("getUserRoleByUserId");
		return daoFeignService.generel(JsonUtil.createGsonString(daoParam));
	}
	
}
