package com.wtl.DAOService.Config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * Mybatis配置
 * @ClassName: MybatisConfiguration
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月4日 下午11:48:09
 */
@Configuration
@AutoConfigureAfter(DataSourceConfiguration.class)
public class MybatisConfiguration {
	@Value("${mysql.datasource.readSize}")
	private String readDataSourceSize;
	@Value("${mysql.datasource.mapperLocations}")
	private String mapperLocations;
	@Value("${mysql.datasource.configLocation}")
	private String configLocation;
	
	@Autowired
	@Qualifier("writeDataSource")
	private DataSource writeDataSource;
	
	@Autowired
	@Qualifier("readDataSource")
	private DataSource readDataSource;
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(roundRobinDataSouceProxy());
		
		return null;
	}
	
	/**
	 * 将数据库连接放入路由
	 * @Title: roundRobinDataSouceProxy
	 * @Description: TODO
	 * @return
	 * @return: AbstractRoutingDataSource
	 */
	@Bean
	public AbstractRoutingDataSource roundRobinDataSouceProxy() {
		Map<Object, Object> targetDataSources = new HashMap<Object,Object>();
		targetDataSources.put(DataSourceType.write.getType(), writeDataSource);
		targetDataSources.put(DataSourceType.read.getType(), readDataSource);
		
		final int readSize = Integer.parseInt(readDataSourceSize);
		
		AbstractRoutingDataSource proxy = new AbstractRoutingDataSource() {
			
			@Override
			protected Object determineCurrentLookupKey() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		return null;
	}
}
