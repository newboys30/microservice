package com.bioFish.UserService.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioFish.Entity.User;
import com.bioFish.Params.JsonObject;
import com.bioFish.Params.WebParam;
import com.bioFish.UserService.Service.UserService;
import com.bioFish.Utils.JsonUtil;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@ApiOperation(value = "按照ID查询", notes = "user信息")
	@PostMapping("/getUserById/{id}")
	public String getUserById(@PathVariable Long id) throws Exception {
		return userService.getUserById(id.toString());
	}
	
	@PostMapping("/findAllUsers")
	public String findAllUsers() throws Exception {
		return userService.findAllUser();
	}
	
	@PostMapping("/saveUser")
	public void saveUser() throws Exception {
		Map<String,Object> param = WebParam.changeWebParam(request);
		String str = JsonUtil.createGsonString(param);
		userService.saveUser(str);
	}
	
	@PostMapping("/redisTest")
	public void redisTest() throws Exception {
		userService.redisTest();
	}
	
	@PostMapping("/kafkaTest")
	public void kafkaTest() throws Exception {
		userService.kafkaTest();
	}
	
	/**
	 * 用户注册
	 * @Title: registUser
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: JsonObject
	 */
	@PostMapping("/registUser")
	public JsonObject registUser() throws Exception{
		JsonObject json = new JsonObject();
		boolean success = false;
		User user = (User) WebParam.changeWebParam(request, User.class);
		Map<String,Object> retMap = userService.registUser(user);
		
		String retFlag = retMap.get("retFlag").toString();
		if("1".equals(retFlag)) {
			success = true;
		}
		json.setSuccess(success);
		json.setMsg(retMap.get("retMsg").toString());
		return json;
	}
	
}
