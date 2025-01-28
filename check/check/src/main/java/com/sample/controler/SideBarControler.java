package com.sample.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SideBarControler {

	@GetMapping("/studentprofile") 
	private String profilebutton(Model m1) {
		return "studentprofile";
	}
	
	@GetMapping("/studentdashboardbtn")
	private String studentdashbordbtn(Model m1) {
		return "studentdashboardbtn";
	}
}
