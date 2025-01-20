package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminService{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public void addinfo(String name) {
		String sql = "INSERT INTO admin (username) VALUES (?)";
		jdbc.update(sql, name);
	}
	
}
