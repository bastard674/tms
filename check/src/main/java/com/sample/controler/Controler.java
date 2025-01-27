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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.entity.Course;
import com.sample.entity.Students;
import com.sample.entity.Users;
import com.sample.repository.CourseDb;
import com.sample.repository.Remo;
import com.sample.repository.UsersDb;
import com.sample.service.CourseService;
import com.sample.service.StudentService;

@Controller
@RequestMapping("/")
public class Controler {
	
	@Autowired
    private Remo studentRepository;
	
	@Autowired 
	private CourseDb coursedb;
	
	@Autowired
	private Remo studentsdb;
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private CourseService courseservice;
	
	@Autowired 
	private UsersDb usersdb;
	

	
	@GetMapping("/register")
	public String showDropdown(Model m1) {
		List<Course> course = courseservice.showDropdown();
		m1.addAttribute("courses",course);
		return "register";
		
	}
	
	@PostMapping("/register")
	private String Register(
			@RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("course") String coursename,
            RedirectAttributes redirectAttributes,
			Model m1) { 
	coursename = coursename.trim();
	Course selectedcourse = coursedb.findByCoursename(coursename).orElseThrow(() -> new RuntimeException("Course was not found:"));
	
	Students savedStudent = studentservice.addinfo(name, password, email, coursename);
    
    redirectAttributes.addFlashAttribute("registrationSuccess", "Registration Successful");
    return "redirect:/register";
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
             Students st = studentRepository.save(s);
             
             
             String newstatus = st.getStatus();
             String name = st.getName();
             String password = st.getPassword();
             if (newstatus.contentEquals("accepted")) {
            	    Users userNew = new Users();
            		userNew.setUsername(name);
            		userNew.setPassword(password);
            		userNew.setRole("Trainee");
            		Users savedUser = usersdb.save(userNew);
            		st.setUser(savedUser);
            		studentservice.addUserId(savedUser.getId(),st.getId());
            	    }

            return ResponseEntity.ok("Status updated successfully");
        } else {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update status for ID: " + id);

        }
    }
    
    @GetMapping("/studentdashboard")
    public String studentlogin(Model m1) {
    	return "studentdashboard";
    	
    }
}