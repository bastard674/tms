package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Course;
import com.sample.repository.CourseDb;

@Service
public class CourseService{

	@Autowired
	private CourseDb coursedb;
	
	
	public List<Course> showDropdown(){
		return coursedb.findAll() ;
		
	}
	
	
	
}