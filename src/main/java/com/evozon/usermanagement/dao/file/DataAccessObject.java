package com.evozon.usermanagement.dao.file;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.evozon.usermanagement.dao.IDataAccessObject;
import com.evozon.usermanagement.model.User;
@Component
public class DataAccessObject implements IDataAccessObject {
	@Override
	public List<User> readUsersFromFile() {
		BufferedReader bufferedreader = null;
		List<User> userList = new ArrayList<User>();
		try {
			bufferedreader = new BufferedReader(new FileReader("C:\\Mara\\workspace\\UserManagement\\file.csv"));
			String line = "";
			User u; 
			while((line = bufferedreader.readLine())!= null) { 
				if(!line.equals(" ")){
					String[] temp = line.split(",");
					u = new User(temp[0], temp[1]);
					userList.add(u);
				}	
			}
		} catch(IOException ioex){
			throw new FileDAOException("Wrong file",ioex);
		} finally {
				if(bufferedreader != null){
					try {
						bufferedreader.close();
					} catch (IOException e) {
						throw new FileDAOException("Cannot close BufferedReader",e);
					}
				}
		}
		return userList;
	}
}
