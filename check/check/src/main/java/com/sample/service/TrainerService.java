package com.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sample.entity.Course;
import com.sample.entity.Students;
import com.sample.entity.Trainer;
import com.sample.repository.LoginDb;
import com.sample.repository.Remo;
import com.sample.repository.TrainerDb;



@Service
public class TrainerService {
	
	
	
	@Autowired 
	private JdbcTemplate jdbc;
	
	@Autowired
	private LoginDb logindb;
	
	@Autowired
	private TrainerDb trainerdb;
	
	@Autowired
	private Remo studentdb;
	
	
	public void addinfo(Trainer trainer) {
		trainerdb.save(trainer);
	}
	
	public Trainer checkdetails(String username,String password,String role) {
        Boolean login = logindb.existsByUsernameAndPasswordAndRole(username, password, role);
        if(login) {
            
        	Optional<Trainer> trainerOptional = trainerdb.findByName(username);
            
            if (trainerOptional.isPresent()) {
                return trainerOptional.get();  // Return the trainer if present
            } else {
              return null;
            }
	}
        return null;
	}
	
	public List<Students> getPendingStudents(Long trainerId){
		Trainer trainer = trainerdb.findById(trainerId).orElseThrow(() -> new RuntimeException("Trainer not found"));
		Course course = trainer.getCourse();
		List<Students> pendingStudents = studentdb.findByStatusAndCourse("pending", course);
		return pendingStudents;
	}
}
