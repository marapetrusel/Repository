package com.evozon.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.DataAccessObject;
import com.evozon.usermanagement.data.LoginData;

@Service
public class DefaultLoginService implements LoginService{
	
	@Autowired
	private DataAccessObject dao;
	
	public DefaultLoginService(){
		
	}
	
	
	public boolean validateLoginData(String username, String password){		
		LoginData ld = dao.getByUsername(username);
		if(ld != null && ld.getPassword().equals(password)){
			return true;
		}
		
		return false;
	}

}
