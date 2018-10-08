package com.bioFish.DAOService.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态定义数据源，单例模式，非线程安全
 * @ClassName: DynamicDataSource
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月28日 上午10:00:08
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceHolder.getDataSourceKey();
	}
	
}
