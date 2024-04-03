package com.org.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MessageInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("prehandle () called");
		
		long startTime=System.currentTimeMillis();
		
		request.setAttribute("startTime", startTime);
		
		String clientid =request.getParameter("clientId");	// gettting queryparameters
		if("abhi".equals(clientid)) {
			return true;
		}
		response.getWriter().print("Invalid request");
		return false;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		System.out.println("posthandle () called");
		
		long endTime=System.currentTimeMillis();
		
		long startTime=(long) request.getAttribute("startTime");
		long time =endTime-startTime;
		System.out.println("Total time taking forprocess:"+time);
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
