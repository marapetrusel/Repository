package com.evozon.usermanagement.dao;

import java.util.List;

import com.evozon.usermanagement.model.User;

public interface IDataAccessObject {
	public List<User> readUsersFromFile();
}
