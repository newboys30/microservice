package com.wtl.DAOService.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfig{
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.read")
	public DataSource druidDataSource() {
		DataSource source = new DruidDataSource();
		try {
			System.out.println(source.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return source;
	}
	
	
}
