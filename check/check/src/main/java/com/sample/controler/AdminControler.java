package com.sample.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.entity.Admin;
import com.sample.entity.Course;
import com.sample.entity.Login;
import com.sample.entity.Trainer;
import com.sample.repository.CourseDb;
import com.sample.service.AdminService;
import com.sample.service.CourseService;
import com.sample.service.LoginService;
import com.sample.service.TrainerService;


@Controller
public class AdminControler{
	
	
	@Autowired 
	private CourseService courseservice;
	
	@Autowired 
	private TrainerService trainerservice;
	
	@Autowired 
	private CourseDb coursedb;
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private AdminService adminservice;
	
	@GetMapping("/admindashboard")
	public String admindashboard(Model m1) {
		return "admindashboard";
	}
	
	@GetMapping("/addUser")
	public String showAddTrainer(Model m1) {
		List<Course> course = courseservice.showDropdown();
		m1.addAttribute("courses",course);
	    return "addUser"; // Assuming JSP is mapped correctly in View Resolver
	}
	
	
	@PostMapping("/addUser")
	@ResponseBody
	public String recieveTrainerDetails(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("course") String coursename,
			@RequestParam("role") String role,
			Model m1) {
		coursename = coursename.trim();
		Course selectedcourse = coursedb.findByCoursename(coursename).orElseThrow(() -> new RuntimeException("Course was not found:"));
		
		if(role.equals("Trainer")) {
			Trainer trainer = new Trainer();
			trainer.setCourse(selectedcourse);
			trainer.setName(userName);
			
			Login login = new Login();
			login.setUsername(userName);
			login.setPassword(password);
			login.setRole(role);
			trainerservice.addinfo(userName, selectedcourse.getId());
			
		}
		
		else if (role.equals("Admin")) {
			Admin admin = new Admin();
			admin.setUsername(userName);
			
			Login login = new Login();
			login.setUsername(userName);
			login.setPassword(password);
			login.setRole(role);
			
			adminservice.addinfo(userName);
		}
		loginservice.addinfo(userName, password, role);
		return "success";
	
	}
}