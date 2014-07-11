package com.evozon.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.IDataAccessObject;
import com.evozon.usermanagement.model.User;

@Service
public class LoginService implements ILoginService {	
	@Autowired
	IDataAccessObject dao;
	public boolean compare(String username, String password)
	{
		List<User> list= new ArrayList<User>();
		list=dao.readFromFile();
		for( User user:list){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
}