package com.easylearnjava.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {
	
	@RequestMapping("/guest")
	public String sayHello() {
		return "Hello Guest!";
	}
	
	@RequestMapping("/guest/demo")
	public String sayHelloDemo() {
		return "Hello Guest Demo!";
	}
}
