package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sample.entity.Admin;
import com.sample.repository.AdminDb;

@Service
public class AdminService{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired 
	private AdminDb admindb;
	
	public void addinfo(Admin admin) {
		admindb.save(admin);
	}
	
}
