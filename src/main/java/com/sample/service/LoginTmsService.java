package com.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Users;
import com.sample.repository.UsersDb;

@Service
public class LoginTmsService {

	@Autowired 
	private UsersDb usersdb;
	
	public Users verifydetails(String username,String password,String role) {
		Optional<Users> optionalUser = usersdb.findByUsernameAndRole(username, role);
		
		if (optionalUser.isPresent()) {
            Users user = optionalUser.get(); 
            boolean vai = user.getPassword().equals(password);
            if(vai) {
            	return user;
            }
        }
		return null; 
	}

}
