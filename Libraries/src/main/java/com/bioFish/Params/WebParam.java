package com.bioFish.Params;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * 页面参数转换工具
 * @ClassName: WebParam
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月17日 上午9:49:40
 */
public class WebParam {
	/**
	 * 页面参数解析函数
	 * @Title: changeWebParam
	 * @Description: TODO
	 * @param request
	 * @return
	 * @return: Map<String,Object>
	 */
	public static Map<String,Object> changeWebParam(HttpServletRequest request) {
		Map<String,String[]> properties = request.getParameterMap();
		Map<String,Object> returnMap = new HashMap<String,Object>(); 
		Iterator entries = properties.entrySet().iterator(); 
		Map.Entry entry; 
		String name = "";  
		String value = "";  
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next(); 
			name = (String) entry.getKey(); 
			Object valueObj = entry.getValue(); 
			if(null == valueObj){ 
				value = ""; 
			}else if(valueObj instanceof String[]){ 
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){ 
					 value = values[i] + ",";
				}
				value = value.substring(0, value.length()-1); 
			}else{
				value = valueObj.toString(); 
			}
			returnMap.put(name, value.trim()); 
		}
		return returnMap;
	}
	
}
