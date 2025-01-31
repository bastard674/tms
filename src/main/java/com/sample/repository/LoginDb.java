package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Login;

@Repository
public interface LoginDb extends JpaRepository<Login, Long>{
	Boolean existsByUsernameAndPasswordAndRole(String username,String password,String role);
	
}