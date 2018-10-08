package com.bioFish.DAOService.Execute;

import com.bioFish.Utils.JsonUtil;

/**
 * 执行基础类
 * @ClassName: BaseExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月8日 下午11:37:57
 */
public class BaseExecute {
	
	/**
	 * 通用Json转Object
	 * @Title: jsonToObject
	 * @Description: TODO
	 * @param jsonStr
	 * @param class1
	 * @return
	 * @throws Exception
	 * @return: Object
	 */
	public Object jsonToObject(String jsonStr,String classname) throws Exception{
		Object obj = JsonUtil.changeGsonToBean(jsonStr, classname.getClass());
		return obj;
	}
}
