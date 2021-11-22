package com.niyuj.group.userSession;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	
String sts;
String mts;
String[] files1;
	
private static HashMap<String, User> map= new HashMap<String, User>();
	
public static HashMap<String, User> getMap() {
	return map;
}

public static void setMap(HashMap<String, User> map) {
	LoginService.map = map;
}


public void addUser(User user) {
	map.put(user.getToken(),user );
	System.out.println(map);
	
}

public void deleteUser(String token) {
	System.out.println(token);
			map.remove(token);
			System.out.println("user has been deleted from map");
	System.out.println(map.keySet());
}

public String getCwd(String token) {
	
		  sts=map.get(token).getPwd().toString();
			System.out.println(sts);
			System.out.println("CWD has been returned");
	        return sts;
}

public String getList(String token) {
	  mts=map.get(token).getHomeDir().toString();
	  File fl=new File(mts);
	  String list[]=fl.list();
	  return (Arrays.toString(list));
}

public String changeDir(String dirName, String token) {
	
	User user=new User();
	user.setUsername(map.get(token).getUsername().toString());
	user.setToken(token);
	user.setHomeDir(User.baseDir + "/" +map.get(token).getUsername().toString());
	user.setPwd(User.baseDir + "/" +map.get(token).getUsername().toString() + "/" +dirName);
	map.replace(token, user);
	return map.get(token).getPwd().toString();
	
}

	
		
	

	

}
