package org.salman.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public Object getTodos(@RequestBody Object request) {
		try {
			LOGGER.info("hello world");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}
}