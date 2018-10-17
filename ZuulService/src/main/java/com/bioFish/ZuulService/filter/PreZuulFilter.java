package com.bioFish.ZuulService.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * zuul过滤器
 * @ClassName: PreZuulFilter
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月17日 下午6:04:17
 */
public class PreZuulFilter extends ZuulFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String host = request.getRemoteHost();
		LOGGER.info("host======" + host);
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}
	
	/**
	 * 执行顺序，数字越小越先执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
