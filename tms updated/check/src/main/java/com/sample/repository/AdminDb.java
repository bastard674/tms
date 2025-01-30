package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Admin;

@Repository
public interface AdminDb extends JpaRepository<Admin,Long> {
	
	
}
