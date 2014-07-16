package com.evozon.usermanagement.dao.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





import org.springframework.stereotype.Component;

import com.evozon.usermanagement.dao.DataAccessObject;
import com.evozon.usermanagement.data.LoginData;

@Component
public class FileDataAccessObject implements DataAccessObject {


	private List<LoginData> users;

	public FileDataAccessObject() {
		
	}

	private List<LoginData> readFromFile() {
		List<LoginData> listOfUsers = new ArrayList<LoginData>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Razvan\\Environment\\sts\\STSWorkspace\\UserManagement\\data.csv"));
			String line = null;

			while ((line = reader.readLine()) != null){
				if(!line.equals("")){
					String[] loginParts = line.split(",");
					String username = loginParts[0];
					String pass = loginParts[1];

					LoginData ld = new LoginData(username, pass);
					listOfUsers.add(ld);
				}
			}

			reader.close();

		}catch(IOException ex){
			throw new FileDAOException("Wrong file format", ex);
		}

		return listOfUsers;
	}


	@Override
	public LoginData getByUsername(String user) {
		List<LoginData> users =  getAllUsers();

		for (LoginData ld : users){
			if(ld.getUsername()!=null && ld.getUsername().equals(user)){
				return ld;
			}
		}


		return null;
	}


	private List<LoginData> getAllUsers() {
		if(users==null){
			initializeUsers();
		}
		return users;
	}
	
	private void initializeUsers() {
		if(users == null){
			users = readFromFile();
		}
	}
}
