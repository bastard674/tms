package com.sample.controler;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.sample.entity.Students;
import com.sample.entity.Trainer;
import com.sample.entity.Users;
import com.sample.repository.CourseDb;
import com.sample.repository.Remo;
import com.sample.repository.TrainerDb;
import com.sample.repository.UsersDb;
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
	private TrainerDb trainerdb;
	
	@Autowired 
	private Remo studentdb;
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private AdminService adminservice;
	
	@Autowired 
	private UsersDb usersdb;
	
	@GetMapping("/admindashboard")
	public String admindashboard(HttpSession http,Model m1) {
		
		Long userId = (Long) http.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/tmslogin";
		}
		
		List<Course> course = coursedb.findAll();
		m1.addAttribute("course", course);
		
		List<Trainer> trainer = trainerdb.findAll();
		m1.addAttribute("trainer",trainer);
		
		List<Students> student = studentdb.findAll();
		m1.addAttribute("student",student);
		
		m1.addAttribute("userId", userId);
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
			HttpSession http,
			Model m1) {
		coursename = coursename.trim();
		Course selectedcourse = coursedb.findByCoursename(coursename).orElseThrow(() -> new RuntimeException("Course was not found:"));
		Long userId = (Long) http.getAttribute("userId");
		if (userId == null) {
	        throw new RuntimeException("User ID not found in session.");
	    }
		
		Users user = usersdb.findById(userId).orElseThrow(()->new RuntimeException("users not found"));
		
		Users newUser = new Users();
		newUser.setUsername(userName);
		newUser.setPassword(password);
		newUser.setRole(role);
		Users savedUser = usersdb.save(newUser);
		
		if(role.equals("Trainer")) {
			Trainer trainer = new Trainer();
			trainer.setCourse(selectedcourse);
			trainer.setName(userName);
			trainer.setUser(savedUser);
			trainerservice.addinfo(trainer);
			
		}
		
		else if (role.equals("Admin")) {
			Admin admin = new Admin();
			admin.setUsername(userName);
			admin.setUser(savedUser);
			
			adminservice.addinfo(admin);
		}
		
		return "success";
	
	}
}