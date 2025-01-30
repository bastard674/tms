package com.sample.controler;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.entity.Course;
import com.sample.entity.Students;
import com.sample.entity.Trainer;
import com.sample.repository.Remo;
import com.sample.repository.TrainerDb;
import com.sample.service.TrainerService;

@Controller
public class TrainerControler{
	
	@Autowired
	private TrainerService trainerservice;
	
	@Autowired 
	private TrainerDb trainerdb; 
	
	@Autowired 
	private Remo studentRepository;
	
	
	@GetMapping("/trainerdashboard")
	public String showPendingStudents(HttpSession session, Model model) {
	    Long trainerId = (Long) session.getAttribute("trainerId");
	    
	    if (trainerId == null) {
	        return "redirect:/tmslogin";
	    }
	    
	    Optional<Trainer> trainerOpt = trainerdb.findById(trainerId);
	    Long course_id = null;
	    String courseName = null;
	    
	    if (trainerOpt.isPresent()) {
	        Trainer trainer = trainerOpt.get();
	        Course course = trainer.getCourse();
	        course_id = course.getId();
	        courseName = course.getCoursename();
	    } else {
	        System.out.println("Trainer not found for trainer ID: " + trainerId);
	    }
	    
	    List<Students> pendingStudents = trainerservice.getPendingStudents(trainerId);
	    model.addAttribute("students", pendingStudents);
	    model.addAttribute("courseName", courseName);
	    model.addAttribute("courseId", course_id);
	    return "trainerDashboard";
	}

	   
		@GetMapping("/studentlist")
		public String studentlist(Model m1) {
			List<Students> accptdstudents = studentRepository.findByStatus("accepted");
			m1.addAttribute("students",accptdstudents);
			return "studentlist";	}
		
}