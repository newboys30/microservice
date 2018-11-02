package com.bioFish.ZuulService.swaggerConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
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
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider{
	
	@Autowired
	private RouteLocator rotelocator;
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.enable(true)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bioFish.ZuulService"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/");
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

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		resources.add(swaggerResource("zuul-gateway","/v2/api-docs","1.0"));
		
		rotelocator.getRoutes().forEach(rote ->{
			resources.add(swaggerResource(rote.getId(), rote.getFullPath().replace("**", "v2/api-docs"), "1.0"));
		});
		
		return resources;
	}
	
	private SwaggerResource swaggerResource(String name, String localtion, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(localtion);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
	
}
