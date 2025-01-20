package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
	
	
	
	@Autowired 
	private JdbcTemplate jdbc;
	
	public void addinfo(String name,String password,String email,Long courseId) {
		String sql = "INSERT INTO students (name, email, password,course_id) VALUES (?, ?, ?, ?)";
		jdbc.update(sql, name, email, password,courseId);
	}
}
