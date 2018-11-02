package com.bioFish.ZuulService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 测试类
 * @ClassName: DemoController
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月2日 下午4:33:12
 */
@RestController
@RequestMapping("/demo")
@Api(tags = "zuul内部测试")
public class DemoController {
	
	@GetMapping("/hello")
	@ApiOperation(value = "name", notes = "描述,尽可能详细")
	public String hello(String name) {
		
		return name + ",this is zuul api!";
	}
}
