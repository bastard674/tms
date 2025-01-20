package com.sample.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sample.entity.Course;
import com.sample.service.CourseService;

@Controller
public class CourseControler{
	
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/register")
	public String showDropdown(Model m1) {
		List<Course> course = courseservice.showDropdown();
		m1.addAttribute("courses",course);
		return "register";
		
	}
	
}