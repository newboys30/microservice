package com.bioFish.ZuulService.swaggerConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * 配置文档
 * @ClassName: DocumentationConfig
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月1日 下午5:39:28
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		resources.add(swaggerResource("userDemo","/userservice/v1/api-docs","1.0"));
		return resources;
	}
	
	private SwaggerResource swaggerResource(String name,String location,String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
