package com.niyuj.group.userSession;

public class Users {

	public static String username;
	
	//private String token;
	
	//-----------------------CONSTRUCTORS------------------------------------------
	
	public Users(String username) {
		super();
		this.username = username;
	}
	public Users() {}
	
	//----------------------------GETTERS AND SETTERS OF USERNAME------------------
	public static String getUsernme() {
		return username;
	}
	public void setUsernme(String username) {
		this.username = username;
	}
	
}
