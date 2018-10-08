package com.wtl.DAOService.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wtl.DAOService.Config.DataSourceContextHolder;
import com.wtl.DAOService.Config.DataSourceType;

/**
 * service层决定数据源，支持事务
 * @ClassName: DataSourceAopInService
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月8日 下午2:14:17
 */
@Aspect
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@Component
public class DataSourceAopInService implements PriorityOrdered {

	/**
	 * 值越小越优先执行
	 * 在启动类已经加入@EnableTransactionManagement(order = 10)注解
	 */
	@Override
	public int getOrder() {
		return 1;
	}
	
	/**
	 * 如果开启事务，则全部从写库读取
	 * @Title: setReadDataSourceType
	 * @Description: TODO
	 * @return: void
	 */
	@Before(" execution(* com.wtl.DAOService.Execute.impl..*.*(..)) "
			+ "and @annotation(com.wtl.DAOService.DataSource.ReadDataSource) "
			)
	public void setReadDataSourceType() {
		if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())) {
			DataSourceContextHolder.setRead();
		}
	}
	
	/**
	 * 写库
	 * @Title: setWriteDataSourceType
	 * @Description: TODO
	 * @return: void
	 */
	@Before(" execution(* com.wtl.DAOService.Execute.impl..*.*(..)) "
			+ "and @annotation(com.wtl.DAOService.DataSource.WriteDataSource) "
			)
	public void setWriteDataSourceType() {
		DataSourceContextHolder.setWrite();
	}
	
}
