package com.example.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestingController {
	
	Logger log=LoggerFactory.getLogger(TestingController.class);
	@GetMapping("/")
	public String myMessage()
	{
		log.debug("Response welcome to my messsage ");
		
		return "welcome to loggeer";
	}

}
