package com.evozon.usermanagement.service;

import org.springframework.stereotype.Service;

import com.evozon.usermanagement.model.User;

@Service
public class LoginService implements ILoginService {
	
	private static final String USERNAME="mara";
	private static final String PASS="bla";
	
	public boolean compare(String username, String password)
	{
		if ( USERNAME.equals(username) && PASS.equals(password) )
		return true;
		
		return false;
	}

}
;