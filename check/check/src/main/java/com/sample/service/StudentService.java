package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sample.entity.Course;
import com.sample.entity.Students;
import com.sample.repository.CourseDb;
import com.sample.repository.Remo;



@Service
public class StudentService {
	
	@Autowired
	private Remo remo;
	
	
	@Autowired 
	private CourseDb coursedb;
	@Autowired 
	private JdbcTemplate jdbc;
	
	public Students addinfo(String name, String password, String email,String coursename) {
	    // Create a new student object
		coursename = coursename.trim();
		Course selectedcourse = coursedb.findByCoursename(coursename).orElseThrow(() -> new RuntimeException("Course was not found:"));
	    Students student = new Students();
	    student.setName(name);
	    student.setPassword(password);
	    student.setEmail(email);
	    student.setCourse(selectedcourse);  // Assuming the course is set like this
	    
	    // Save the student and return the saved entity with generated ID
	    return remo.save(student);  // Save and return the student with the ID
	}
	
	
	public Students getStudentById(Long studentId) {
	    return remo.findById(studentId)
	            .orElseThrow(() -> new RuntimeException("Student not found"));
	}
	
	public void addUserId(Long userId, Long studentId) {
	    String sql = "UPDATE students SET user_id = ? WHERE id = ?";
	    jdbc.update(sql, userId, studentId);
	}
}
