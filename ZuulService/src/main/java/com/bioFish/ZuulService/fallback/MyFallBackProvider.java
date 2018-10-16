package com.bioFish.ZuulService.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;

/**
 * zuul提供回退
 * @ClassName: UserFallBackProvider
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月16日 下午5:53:58
 */
@Component
public class MyFallBackProvider implements FallbackProvider {
	
	@Override
	public String getRoute() {
		//指定微服务，"*"表示全部
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return this.response(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		if(cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.BAD_REQUEST);
		} else {
			return this.fallbackResponse();
		}
	}
	
	private ClientHttpResponse response(final HttpStatus status) {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				MediaType mt = new MediaType("application","json",Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("服务咱不可用，请稍后...".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				return status.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return status;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return status.value();
			}
			
			@Override
			public void close() {
			}
		};
	}
}
