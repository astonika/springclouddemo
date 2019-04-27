package com.example.demo.component;

import org.springframework.stereotype.Component;

import com.example.demo.service.SchedualServiceHi;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry " + name;
	}
}