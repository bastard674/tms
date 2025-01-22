package com.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entity.Enrollment;
import com.tms.repos.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository endb;
	
	    public void saveEnrollment(Enrollment enrollment) {
	        endb.save(enrollment);
	    }

}
