package com.example.demo;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome() {
		LOG.log(Level.INFO, "calling trace service-hi  ");
		System.out.println(port);
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}

	@RequestMapping("/info")
	public String info() {
		LOG.log(Level.INFO, "calling trace service-hi ");

		return "i'm service-hi";

	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

	@Value("${server.port}")
	String port;

//	@RequestMapping("/hi")
//	public String name(@RequestParam String name) {
//		return "hi " + name + ",i am from port:" + port;
//	}

}
