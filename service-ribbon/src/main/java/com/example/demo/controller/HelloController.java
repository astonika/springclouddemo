package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String hi(@RequestParam String name) {
		return "hi " + name + ",i am from port:" + port + " " + helloService.hiService(name);
	}

}