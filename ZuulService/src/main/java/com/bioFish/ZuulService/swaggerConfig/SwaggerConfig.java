package com.bioFish.ZuulService.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 * @ClassName: SwaggerConfig
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月1日 下午4:49:10
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket createApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("ERP")
				.description("接口文档")
				.termsOfServiceUrl("http://localhost:8040")
				.contact(new Contact("bioFish", "", "bioFish@pyjy.com"))
				.version("v1.0")
				.build();
	}
	
}
