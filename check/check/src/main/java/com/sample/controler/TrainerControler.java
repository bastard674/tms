package com.sample.controler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.entity.Students;
import com.sample.entity.Trainer;
import com.sample.service.TrainerService;

@Controller
public class TrainerControler{
	
	@Autowired
	private TrainerService trainerservice;
	

	
	@GetMapping("/trainerlogin")
	public String trainerlogin(Model m1) {
		return "trainerlogin";	
	}
	
	@PostMapping("/trainerlogin")
	public String fun(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session,
		Model m1
			){
		Trainer trainer = trainerservice.checkdetails(username, password,"Trainer");
		if(trainer != null) {
			session.setAttribute("trainerId",trainer.getId());
			return "redirect:/trainerdashboard";	
		}
		else {
			m1.addAttribute("errorMessage","invalid username or password");
			return "trainerlogin";
		}
	}
	
	   @GetMapping("/trainerdashboard")
	    public String showPendingStudents(HttpSession session,Model model) {
		   
		    Long trainerId = (Long) session.getAttribute("trainerId");
		    
		    if (trainerId == null) {
	            return "redirect:/trainerlogin";
	        }
		    
	        List<Students> pendingStudents = trainerservice.getPendingStudents(trainerId);
	        model.addAttribute("students", pendingStudents);
	        return "trainerDashboard"; 
	    }
}