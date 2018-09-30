package com.wtl.DAOService.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/**
 * 数据源配置
 * @ClassName: DataSourceConfiguration
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月30日 下午6:11:52
 */
@Configuration
public class DataSourceConfiguration {
	
	@Value("${mysql.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
	
	/**
	 * 写库
	 * @Title: writeDataSource
	 * @Description: TODO
	 * @return
	 * @return: DataSource
	 */
	@Bean(name = "writeDataSource")
	@ConfigurationProperties(prefix = "mysql.datasource.write")
	@Primary
	public DataSource writeDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * 读库
	 * @Title: writeDataSource
	 * @Description: TODO
	 * @return
	 * @return: DataSource
	 */
	@Bean(name = "readDataSource")
	@ConfigurationProperties(prefix = "mysql.datasource.read")
	public DataSource readDataSource() {
		return DataSourceBuilder.create().build();
	}
}
