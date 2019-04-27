package com.springboot.rest.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.rest.restdemo.interceptor.AuthenticationInterceptor;
import com.springboot.rest.restdemo.interceptor.LoggerInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	LoggerInterceptor logInterceptor;
	@Autowired
	AuthenticationInterceptor authenticationInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor);
		registry.addInterceptor(authenticationInterceptor);
	}
}
