package com.niyuj.group.userSession;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
 
	@Autowired
	private LoginService loginService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/restapi/login")
	public Object login(@RequestBody User user){
		 UUID uuid = UUID.randomUUID();
		 String uuidAsString = uuid.toString();
		user.setToken(uuidAsString);
		user.setHomeDir(User.baseDir + "/" + user.getUsername());
		user.setPwd(User.baseDir + "/" + user.getUsername());
		loginService.addUser(user);
		return uuidAsString;
		
	}
	
	}

