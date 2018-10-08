package com.wtl.DAOService.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring工具类
 * @ClassName: SpringContextUtil
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月8日 上午9:41:03
 */
@Component
public class SpringContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringContextUtil.applicationContext == null) {
			SpringContextUtil.applicationContext = applicationContext;
		}
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	
	public static <T>T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
	
}
