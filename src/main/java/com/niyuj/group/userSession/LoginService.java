package com.niyuj.group.userSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	

private static HashMap<Object, Object> map= new HashMap<Object,Object>();
	
public static HashMap<Object,Object> getuser() {
		
		return map;
	}

public void addUser(User user) {
	map.put(user.getToken(),user );
	System.out.println(map);
	
}

	
		
	

	

}
