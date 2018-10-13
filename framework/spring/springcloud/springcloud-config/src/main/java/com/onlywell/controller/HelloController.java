package com.onlywell.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harry
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}
}
