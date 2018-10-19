package com.bioFish.ZuulService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bioFish.ZuulService.filter.PreZuulFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
	
	/**
	 * 正则表达式
	 * @Title: serviceRouteMapper
	 * @Description: TODO
	 * @return
	 * @return: PatternServiceRouteMapper
	 */
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
	}

	@Bean
	public PreZuulFilter preZuulFilter() {
		return new PreZuulFilter();
	}
}
