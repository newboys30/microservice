package com.bioFish.LoginService.Service;

/**
 * 登陆接口
 * @ClassName: LoginService
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月6日 下午5:36:02
 */
public interface LoginService {
	
	/**
	 * 测试kafka请求
	 * @Title: testKafka
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public String testKafka() throws Exception;
	
	/**
	 * 权限树
	 * @Title: roleTree
	 * @Description: TODO
	 * @param user_id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public String roleTree(String user_id) throws Exception;
}
