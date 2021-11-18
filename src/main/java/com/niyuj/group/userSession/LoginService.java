package com.niyuj.group.userSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	

private static HashMap<Object, Object> map= new HashMap<Object,Object>();
	
	{
	map.put(Tokens.uuidAsString, Users.getUsernme());
	System.out.println(map);
	}

public static HashMap<Object,Object> getuser() {
		
		return map;
	}

	public static String getToken() {
        return Tokens.uuidAsString;
        
		
	}

	

}
