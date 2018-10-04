package com.wtl.DAOService.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

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
}
