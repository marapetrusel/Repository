package com.evozon.usermanagement.dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.evozon.usermanagement.model.User;
@Component
public class DataAccessObject implements IDataAccessObject {
	
	List<User> listaUser = new ArrayList<User>();
	
	public List<User> readFromFile() {
		BufferedReader br = null;
		List<User> userList = new ArrayList<User>();
		try {
			br = new BufferedReader(new FileReader("C:\\Mara\\workspace\\UserManagement\\file.csv"));
			String line = "";
			User u; 
			while((line = br.readLine())!= null) { 
				if(!line.equals(" ")){
					String[] temp = line.split(",");
					u = new User(temp[0], temp[1]);
					userList.add(u);
				}	
			}
		} catch(IOException ioex){
			System.out.println(ioex.getMessage());
		} finally {
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}
}
