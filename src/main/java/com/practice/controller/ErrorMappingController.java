package com.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorMappingController {
	
	@RequestMapping(method = RequestMethod.GET,produces ="text/html")
	public String getGeneralErrorMessage()
	{
		return "<h3>Service Unavailable</h3><br><p>Health Insurance Service is currently unavailable. Please try after sometime.</p>";
	}

}
