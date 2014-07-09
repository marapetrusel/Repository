package com.evozon.usermanagement.model;

public class User {
	
	private String username;
	private String password;
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	
	public String getPassword(){
		return password;
	}


}
