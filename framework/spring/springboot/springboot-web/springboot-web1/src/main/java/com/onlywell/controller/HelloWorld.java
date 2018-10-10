package com.onlywell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {
	
	@GetMapping("/world")
	public String sayHello(String say) {
		if((null == say) || say.equals("hello")) {
			throw new NullPointerException();
		}
		return say + ",world";
	}
	
	public void hi() {
		System.out.println("hahhahah");
	}
	
	public Object hello() {
		return null;
	}
}
