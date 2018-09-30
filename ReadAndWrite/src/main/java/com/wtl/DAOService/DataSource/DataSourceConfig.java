package com.wtl.DAOService.DataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wtl.DAOService.config.DruidDataSourceConfig;

//@Configuration
//@EnableTransactionManagement
public class DataSourceConfig {
	
	//@Autowired
	private DruidDataSourceConfig dataSource;
	
	//@Bean(name = "masterDataSource")
	//@Qualifier("masterDataSource")
	//@ConfigurationProperties(prefix = "spring.datasource.write")
	public DataSource masterDataSource() throws Exception{
		//System.out.println("driver======"+dataSource.getDriverClassName());
		
		//return DataSourceBuilder.create().build();
		return null;
	}
	
}
