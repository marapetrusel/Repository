package com.evozon.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.verifyBestPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.IDataAccessObject;
import com.evozon.usermanagement.model.User;

@Service
public class LoginService implements ILoginService {	
	@Autowired
	IDataAccessObject dao;
	@Override
	public boolean verifyInput(String username, String password)
	{
		List<User> usersList= new ArrayList<User>();
		usersList=dao.readUsersFromFile();
		for( User user:usersList){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
}