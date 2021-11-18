package com.niyuj.group.userSession;

import java.util.UUID;

public class Tokens {
	
private String Tokens;

public Tokens(String tokens) {
	super();
	Tokens = tokens;
}
public Tokens() {
	
}


public String getTokens() {
	return Tokens;
}

static UUID uuid = UUID.randomUUID();
static String uuidAsString = uuid.toString();


//public void setTokens(String tokens) {
	//Tokens = tokens;
//}

















}
