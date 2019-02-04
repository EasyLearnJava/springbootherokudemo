package com.easylearnjava.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("RequestLoggerInterceptor")
public class RequestLoggerInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggerInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		
		LOGGER.info("********** Start of Request Info **********");
		LOGGER.info("********** Requested URL {} ", request.getRequestURI());
		LOGGER.info("********** Request from user agent {} ", request.getHeader("user-agent"));
        LOGGER.info("********** Request from Proxy Ip {} ", request.getRemoteAddr());
        LOGGER.info("********** Request from actual client IP {} : ", request.getHeader("X-Forwarded-For"));
        
        Map<String, String> items = getHeadersInfo(request);
        
        items.forEach((key,value)->System.out.println("################# Header : " + key + " value : " + value));
        
        LOGGER.info("########## End of Request Info ##########");
        
        return true;
    }
	
	

	//get request headers
	private Map<String, String> getHeadersInfo(HttpServletRequest request) {

		Map<String, String> map = new HashMap<String, String>();

		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}

		return map;
	}

}
