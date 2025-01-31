package com.sample.controler;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.entity.Trainer;
import com.sample.entity.Users;
import com.sample.repository.TrainerDb;
import com.sample.service.LoginTmsService;
import com.sample.service.TrainerService;

@Controller
public class MainLoginControler {
	
	@Autowired 
	private LoginTmsService tmsloginservice;
	
	@Autowired
	private TrainerService trainerservice;
	
	@Autowired 
	private TrainerDb trainerdb;

	@GetMapping("/tmslogin")
	private String tmslogin() {
		return "tmslogin";
		}
	
	@PostMapping("/tmslogin")
	private String takingdetails(
			@RequestParam ("username") String username,
			@RequestParam ("password") String password,
			@RequestParam ("role") String role,
			HttpSession http,
			Model m1) {
	Users user  = tmsloginservice.verifydetails(username, password, role);
	
	if(user!= null) {
		
		http.setAttribute("role", role);
		http.setAttribute("userId", user.getId());
		
		if("Admin".equals(role)) {
			return "redirect:/admindashboard";
		}
		
		
		else if("Trainer".equals(role)) {
			Optional<Trainer> trainerOpt = trainerdb.findByUser_Id(user.getId());
			Long trainerId = null;
			if (trainerOpt.isPresent()) {
			    Trainer trainer = trainerOpt.get(); // Get the Trainer object
			    trainerId = trainer.getId(); // Retrieve the trainer_id
			    http.setAttribute("trainerId",trainerId);
				return "redirect:/trainerdashboard";
			    
			} else {
			    System.out.println("Trainer not found for user ID: " + user.getId());
			    return "redirect:/tmsloginn";
			}
			
		}
		
		
		else if("Trainee".equals(role)) {
			return "redirect:/studentdashboard";
		}
		
		}
	
	return "redirect:/loginfailed";

	}
}
