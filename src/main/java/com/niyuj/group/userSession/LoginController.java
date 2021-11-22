package com.niyuj.group.userSession;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
 
	@Autowired
	private LoginService loginService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/restapi/login")//how username is getting stored?
	public  CommandResponse login(@RequestBody User user){
		 UUID uuid = UUID.randomUUID();
		 String uuidAsString = uuid.toString();
		user.setToken(uuidAsString);
		user.setHomeDir(User.baseDir + "/" + user.getUsername());
		user.setPwd(User.baseDir + "/" + user.getUsername());
		loginService.addUser(user);
		File f1 = new File(user.getHomeDir());
		 boolean bool1 = f1.mkdirs();  
	      if(bool1){  
	         System.out.println("Folder is created successfully");  
	      }else{  
	         System.out.println("File already exists");  
	      }  
		CommandResponse cr=new  CommandResponse();
		cr.setCommand("login");
		cr.setResult(uuidAsString);
		return cr;
		
		
	}
	
//----------------------------------------------------------------------------
	
	@RequestMapping(method=RequestMethod.DELETE,value="/restapi/logout")
	public String logout(@RequestHeader(value="Authorization") String token) {
		loginService.deleteUser(token);
		
		return "logout successfull,your token has been deleted";
	}
	
	
//--------------------------------------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET, value="/restapi/cwd")
	public  CommandResponse currentDirectory(@RequestHeader(value="Authorization") String token){
	String  cwd=loginService.getCwd(token);
	CommandResponse cr=new  CommandResponse();
	cr.setCommand("cwd");
	cr.setResult(cwd);
	return cr;
	
}
	
//-------------------------------------------------------------------------------------------------


	@RequestMapping(method=RequestMethod.GET, value="/restapi/ls")
	public String filesList(@RequestHeader(value="Authorization") String token){
		String ls= loginService.getList(token);
		CommandResponse cr=new  CommandResponse();
		cr.setCommand("cwd");
		cr.setResult(ls);
		return ls;
			
		}
//-----------------------------------------------------------------------------------------------------------
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/restapi/cd/{dirName}")
	public String changeDirectory(@RequestHeader(value="Authorization") String token, @PathVariable String dirName) {
	
		return "Directory changed to"+loginService.changeDir(dirName,token);
		
		
			
		}
	
	
	
	
	
	}
	
	












