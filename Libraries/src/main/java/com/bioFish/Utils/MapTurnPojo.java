package com.bioFish.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * map与实体类相互转换工具
 * @ClassName: MapTurnPojo
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月13日 下午5:27:38
 */
public class MapTurnPojo {
	
	/**
	 * 实体类转换为map
	 * @Title: objectToMap
	 * @Description: TODO
	 * @return
	 * @return: Map<String,Object>
	 */
	public static Map<String,Object> objectToMap(Object obj) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(obj == null)
			return map;
		Class<? extends Object> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * map转换为实体类
	 * @Title: mapToObject
	 * @Description: TODO
	 * @param map
	 * @param clazz
	 * @return
	 * @return: Object
	 */
	public static Object mapToObject(Map<String,Object> map, Class<?> clazz) {
		if(null == map)
			return null;
		Object obj = null;
		try {
			obj = clazz.newInstance();
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				int mod = field.getModifiers();
				if(Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
					continue;
				}
				field.setAccessible(true);
				field.set(obj, map.get(field.getName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
