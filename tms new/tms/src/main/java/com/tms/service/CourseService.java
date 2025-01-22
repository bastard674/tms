package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entity.Course;
import com.tms.repos.CourseRepository;


@Service
public class CourseService {

	@Autowired
	private CourseRepository coursedb;
	
	
	public List<Course> showDropdown(){
		return coursedb.findAll() ;
		
	}
}
