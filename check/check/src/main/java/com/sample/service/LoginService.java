package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginService{
	
	@Autowired 
	private JdbcTemplate jdbc;
	
	public void addinfo(String name,String password,String role) {
		String sql = "INSERT INTO login (username,password,role) VALUES (?, ?, ?)";
		jdbc.update(sql, name,password,role);
	}
	
}