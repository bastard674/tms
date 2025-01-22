package com.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tms.entity.Course;
import com.tms.entity.Enrollment;
import com.tms.entity.Students;
import com.tms.repos.CourseRepository;
import com.tms.service.CourseService;
import com.tms.service.EnrollmentService;
import com.tms.service.StudentService;


@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	@Autowired
	private EnrollmentService enrollmentservice;
	@Autowired 
	private CourseRepository coursedb;
	
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/register")
	public String showregister(Model m1) {
		List<Course> course = courseservice.showDropdown();
		m1.addAttribute("courses",course);
		return "register";
		
	}
	
	@PostMapping("/register")
	@ResponseBody
	private String Register(
			@RequestParam("name") String name,
            @RequestParam("password") String password,
           
            @RequestParam("course") String coursename,
			Model m1) { 
	coursename = coursename.trim();
	Course selectedcourse = coursedb.findByCoursename(coursename).orElseThrow(() -> new RuntimeException("Course was not found:"));
	// Create and populate the Students object
    Students student = new Students();
    student.setName(name);
    student.setPassword(password);
    student.setCourse(selectedcourse);
    
    // Save the student object, including the course
    Students savedStudent = studentservice.addinfo(name, password, selectedcourse.getId());
    
    Enrollment enrollment = new Enrollment();
    enrollment.setStudent(savedStudent); // Set the student
    enrollment.setCourse(selectedcourse); // Set the course

    // Save the enrollment object

    
	return "Success";
	
	}
	
	

}
