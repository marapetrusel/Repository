package com.evozon.usermanagement.dao;

import com.evozon.usermanagement.data.LoginData;

public interface DataAccessObject {
	
	
//	public void initializeUsers(); //fara
	public LoginData getByUsername(String user);
}
