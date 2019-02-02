package com.easylearnjava.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestLoggerInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggerInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		
        LOGGER.info("Request {} from Proxy Ip {} ", request.getRequestURI(), request.getRemoteAddr());
        LOGGER.info("Request {} from actual client IP {} : ", request.getRequestURI(), request.getHeader("X-Forwarded-For"));

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LOGGER.info("Request remote address {} from client host heroku name {} : ", req.getRemoteAddr(), req.getRemoteHost());

        
        return true;
    }

}
