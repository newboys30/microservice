package com.bioFish.ConfigService.Aspect;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 解决数组配置返回json错误切面
 * 高版本可能不需要这个切面？？？待测试
 * @ClassName: EnvironmentAspect
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月11日 上午10:07:48
 */
@Aspect
@Component
public class EnvironmentAspect {
	private final Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
	
	@Pointcut("execution(* org.springframework.cloud.config.server.environment.EnvironmentController.*(..))")
	public void getResource() {
	}
	
	@Around("getResource()")
	public Object labelledJson(ProceedingJoinPoint pjp) throws Throwable{
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		
		Object object = pjp.proceed();
		finalOutput(response,object);
		return object;
	}
	
	/**
	 * 执行方法
	 * @Title: finalOutput
	 * @Description: TODO
	 * @param response
	 * @param object
	 * @return: void
	 */
	private void finalOutput(HttpServletResponse response, Object result) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		String jsonStr = gson.toJson(result);
		
		writeData(response, jsonStr);
	}
	
	private void writeData(HttpServletResponse response, String jsonStr) throws IOException {
		try {
			response.getOutputStream().write(jsonStr.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
}
