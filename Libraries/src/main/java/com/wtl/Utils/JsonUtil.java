package com.wtl.Utils;

import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * Json工具
 * @ClassName: JsonUtil
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月17日 上午10:16:39
 */
public class JsonUtil {
	
	/**
	 * Object转Json字符串
	 * @Title: createGsonString
	 * @Description: TODO
	 * @param object
	 * @return
	 * @return: String
	 */
	public static String createGsonString(Object object) {
		Gson gson = new Gson();
		String gsonString = gson.toJson(object);
		return gsonString;
	}
	
	/**
	 * Json转Bean
	 * @Title: changeGsonToBean
	 * @Description: TODO
	 * @param gsonString
	 * @param cls
	 * @return
	 * @return: T
	 */
	public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		T t = gson.fromJson(gsonString, cls);
		return t;
	}
	
	/**
	 * Json转List<Bean>
	 * @Title: changeGsonToList
	 * @Description: TODO
	 * @param gsonString
	 * @param cls
	 * @return
	 * @return: List<T>
	 */
	public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
		}.getType());
		return list;
	}
	
	/**
	 * Json转List<Map>
	 * @Title: changeGsonToList
	 * @Description: TODO
	 * @param gsonString
	 * @return
	 * @return: List<T>
	 */
	public static <T> List<Map<String,Object>> changeGsonToListMaps(String gsonString) {
		Gson gson = new Gson();
		List<Map<String, Object>> list = null;
		list = gson.fromJson(gsonString, new TypeToken<List<Map<String,Object>>>() {
		}.getType());
		return list;
	}
	
	/**
	 * Json转Map
	 * @Title: changeGsonToMaps
	 * @Description: TODO
	 * @param gsonString
	 * @return
	 * @return: Map<String,Object>
	 */
	public static <T> Map<String,Object> changeGsonToMaps(String gsonString) {
		Gson gson = new Gson();
		Map<String, Object> map = null;
		map = gson.fromJson(gsonString, new TypeToken<Map<String,Object>>() {
		}.getType());
		return map;
	}
	
	
}
