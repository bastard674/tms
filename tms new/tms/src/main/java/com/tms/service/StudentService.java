package com.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tms.entity.Students;

@Service
public class StudentService {

	@Autowired 
	private JdbcTemplate jdbc;
	
	public Students addinfo(String name, String password, Long courseId) {
	    // Insert into the Students table
	    String insertStudentSql = "INSERT INTO students (name, password, course_id) VALUES (?, ?, ?)";
	    jdbc.update(insertStudentSql, name, password, courseId);

	    // Retrieve the generated student ID (assuming `students` table has an auto-increment ID)
	    String getStudentIdSql = "SELECT MAX(stu_id) FROM students";
	    Long studentId = jdbc.queryForObject(getStudentIdSql, Long.class);

	    // Insert into the Enrollment table
	    String insertEnrollmentSql = "INSERT INTO enrollment (student_id, course_id) VALUES (?, ?)";
	    jdbc.update(insertEnrollmentSql, studentId, courseId);

	    // Return the newly created Students object
	    Students student = new Students();
	    student.setName(name);
	    student.setPassword(password);
	    student.setStu_id(studentId); // Assuming your Students class has an ID field
	    return student;
	}

}
