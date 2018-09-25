package com.wtl.ZKService.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * zk配置
 * @ClassName: ZkConfiguration
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月19日 下午2:33:48
 */
@Configuration
@EnableAutoConfiguration
public class ZkConfiguration {
	
	@Value("${curator.retryCount}")
	private int retryCount;
	
	@Value("${curator.elapsedTimeMs}")
	private int elapsedTimeMs;
	
	@Value("${curator.connectString}")
	private String connectString;
	
	@Value("${curator.sessionTimeoutMs}")
	private int sessionTimeoutMs;
	
	@Value("${curator.connectionTimeoutMs}")
	private int connectionTimeoutMs;
	
	@Bean
	public CuratorFramework curatorFramework() {
		return CuratorFrameworkFactory.newClient(connectString, sessionTimeoutMs, connectionTimeoutMs, 
				new RetryNTimes(retryCount, elapsedTimeMs));
	}
	
}
