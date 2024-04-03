package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ControllerClass {
	@GetMapping("/welcome")
	public String welcomeMsg() {
		
		return "learning Interceptor";
	}
	
	@GetMapping("/greet")
	public String greetMsg() {
		
		return "Good Evening :)";
	}
}
