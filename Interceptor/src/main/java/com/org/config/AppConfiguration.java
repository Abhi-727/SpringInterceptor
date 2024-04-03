package com.org.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.org.interceptor.MessageInterceptor;

@Configuration
public class AppConfiguration extends WebMvcConfigurationSupport  {
	
	@Autowired
	private MessageInterceptor intercept;
	
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(intercept);
	}
}


//Caused by: java.lang.IllegalArgumentException: Interceptor is required
//Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate
//[org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping]:
//Factory method 'requestMappingHandlerMapping' threw exception with message: Interceptor is required
//org.springframework.beans.factory.BeanCreationException: Error creating bean with name
//'requestMappingHandlerMapping' defined in class path resource [com/org/config/AppConfiguration.class]:
//Failed to instantiate [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping]:
//Factory method 'requestMappingHandlerMapping' threw exception with message: Interceptor is required
//--@Autowired -missing

