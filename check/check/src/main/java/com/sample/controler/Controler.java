package com.sample.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.entity.Course;
import com.sample.entity.Students;
import com.sample.repository.CourseDb;
import com.sample.repository.Remo;
import com.sample.service.StudentService;

@Controller
@RequestMapping("/")
public class Controler {
	
	@Autowired
    private Remo studentRepository;
	
	@Autowired 
	private CourseDb coursedb;
	
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/studentlist")
	public String studentlist(Model m1) {
		List<Students> accptdstudents = studentRepository.findByStatus("accepted");
		m1.addAttribute("students",accptdstudents);
		return "studentlist";	}
	
	
	public String showRegisterForm() {
	    return "register"; // Returns the register.html (or register.jsp) form
	}
	
	
	@PostMapping("/register")
	@ResponseBody
	private String Register(
			@RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("course") String coursename,
			Model m1) { 
	coursename = coursename.trim();
	Course selectedcourse = coursedb.findByCoursename(coursename).orElseThrow(() -> new RuntimeException("Course was not found:"));
	// Create and populate the Students object
    Students student = new Students();
    student.setName(name);
    student.setPassword(password);
    student.setEmail(email);
    student.setCourse(selectedcourse);
    
    // Save the student object, including the course
    studentservice.addinfo(name, password, email, selectedcourse.getId());
	return "Success";
	}

    // View list of students
 

    // Update status
    @PostMapping("/updateStatus")
    @ResponseBody
    public ResponseEntity<String> updateStatus(@RequestParam Long id, @RequestParam String status) {
        System.out.println("Received ID: " + id + ", Status: " + status); // Debugging log

        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Students s = student.get();
            s.setStatus(status); // Update status to accepted or rejected
            studentRepository.save(s);

            return ResponseEntity.ok("Status updated successfully");
        } else {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update status for ID: " + id);

        }
    }



}
