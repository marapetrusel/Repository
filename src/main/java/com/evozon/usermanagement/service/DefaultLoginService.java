package com.evozon.usermanagement.service;

import org.springframework.stereotype.Service;

@Service
public class DefaultLoginService implements ILoginService{
	
	private static final String USERNAME = "mrazvan";
	private static final String PASSWORD = "abcd";
	
	
	public boolean validateLoginData(String username, String password){
		if(USERNAME.equals(username) && PASSWORD.equals(password)){
			return true;
		}
		
		return false;
	}

}
