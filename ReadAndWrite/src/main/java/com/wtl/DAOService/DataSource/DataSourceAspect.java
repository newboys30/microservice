package com.wtl.DAOService.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;

/**
 * 定义切面，根据Service方法名切换数据源
 * @ClassName: DataSourceAspect
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月28日 上午10:22:17
 */
public class DataSourceAspect {
	
	/**
	 * 进入service方法之前执行
	 * @Title: before
	 * @Description: TODO
	 * @param point
	 * @return: void
	 */
	public void before(JoinPoint point) {
		String methodName = point.getSignature().getName();
		if(isSlave(methodName)) {
			DynamicDataSourceHolder.markSlave();
		} else {
			DynamicDataSourceHolder.markMaster();
		}
	}
	
	/**
	 * 以query、find、get开头方法为读库
	 * @Title: isSlave
	 * @Description: TODO
	 * @param methodName
	 * @return
	 * @return: Boolean
	 */
	private Boolean isSlave(String methodName) {
		return StringUtils.startsWithAny(methodName, "query", "find", "get");
	}
}
