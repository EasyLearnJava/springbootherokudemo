package com.easylearnjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.easylearnjava.util.RequestLoggerInterceptor;

@Configuration
public class MyAppConfig implements WebMvcConfigurer {
	
	@Autowired
    @Qualifier("RequestLogger")
	RequestLoggerInterceptor requestLogger;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.requestLogger);
    }

}
