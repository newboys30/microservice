package com.wtl.DAOService.Config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfig {
	/**
	 * 读库
	 * @Title: readDruidDataSource
	 * @Description: TODO
	 * @return
	 * @return: DataSource
	 */
	@ConfigurationProperties(prefix = "spring.datasource.druid.read")
    @Bean(name = "readDruidDataSource")
    public DataSource readDruidDataSource() {
        return new DruidDataSource();
    }
	
	/**
	 * 写库
	 * @Title: writeDruidDataSource
	 * @Description: TODO
	 * @return
	 * @return: DataSource
	 */
    @ConfigurationProperties(prefix = "spring.datasource.druid.write")
    @Bean(name = "writeDruidDataSource")
    @Primary
    public DataSource writeDruidDataSource() {
        return new DruidDataSource();
    }
}
