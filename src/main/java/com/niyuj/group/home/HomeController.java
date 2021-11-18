package com.niyuj.group.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/home")
	public String welcomeUser() {
		
		return "Hello user this is the home page of web app";
	}
}