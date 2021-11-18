package com.niyuj.group.userSession;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	//@RequestMapping("/restapi/login")
	//public String login(){
	//	return Users.getUsernme();
	//}
	
	@RequestMapping(method=RequestMethod.POST, value="/restapi/login")
	public Object login(@RequestBody Users username){
		username.setUsernme(Users.username);
		return LoginService.getToken();
	}
	
	}

