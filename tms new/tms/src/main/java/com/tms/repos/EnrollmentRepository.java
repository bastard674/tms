package com.tms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

	
}
