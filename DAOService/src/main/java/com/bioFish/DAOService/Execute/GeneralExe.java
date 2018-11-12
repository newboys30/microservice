package com.bioFish.DAOService.Execute;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioFish.Params.DAOParam;
import com.bioFish.Params.WebParam;
import com.bioFish.Utils.JsonUtil;

/**
 * 通用执行器
 * @author newbo
 * @param <T>
 *
 */
@RestController
public class GeneralExe {
	
	@Autowired
	private BeanTransverter beanTransverter;
	
	/**
	 * 通用执行方法
	 * @Title: generel
	 * @Description: TODO
	 * @param jsonStr DAOParam的json化
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping("/generel")
	public String generel (String jsonStr) throws Exception {
		
		String path = "com.bioFish.DAOService.Execute.impl.";
		DAOParam daoParam = JsonUtil.changeGsonToBean(jsonStr, DAOParam.class);
		String filename = daoParam.getFileName();
		String methods = daoParam.getMethods();
		String param = daoParam.getJsonParam();
		
		Class clazz = Class.forName(path + filename);
		Object obj = beanTransverter.getBean(filename);
		Object retObj;
		
		if("".equals(param) || null == param) {
			retObj = clazz.getMethod(methods).invoke(obj);
		}else {
			retObj = clazz.getMethod(methods, String.class).invoke(obj, param);
		}
		
		return JsonUtil.createGsonString(retObj);
	}
	
}
