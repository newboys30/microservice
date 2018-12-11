package com.bioFish.Oauth2service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据源config
 * @ClassName: ConfigurationProperties
 * @Description: TODO
 * @author: newbo
 * @date: 2018年12月6日 上午10:09:20
 */
//@ConfigurationProperties(prefix = "spring.druid")
public class DruidDataSource {
	private String dbUrl;
	private String username;
	private String password;
	private String driverClassName;
}
