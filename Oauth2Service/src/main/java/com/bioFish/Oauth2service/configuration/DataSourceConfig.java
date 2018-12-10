package com.bioFish.Oauth2service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源config
 * @ClassName: DataSourceConfig
 * @Description: TODO
 * @author: newbo
 * @date: 2018年12月6日 上午10:09:20
 */
@Configuration
public class DataSourceConfig {
	@Value("${spring.datasource.url:#{null}}")
	private String dbUrl;
}
