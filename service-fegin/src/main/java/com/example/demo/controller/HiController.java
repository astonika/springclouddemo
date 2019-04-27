package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SchedualServiceHi;

@RestController
public class HiController {

	@Autowired
	private SchedualServiceHi schedualServiceHi;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(@RequestParam String name) {
		return schedualServiceHi.sayHiFromClientOne(name);
	}

}