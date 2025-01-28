package com.sample.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Enrollment {

	@GetMapping("/enrollment")
	public String enrollpage(Model m1) {
		
		return "enrollment";
		
	}
}
