package com.sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.entity.Users;


@Repository
public interface UsersDb extends JpaRepository<Users,Long> {
	
	Optional<Users> findByUsernameAndRole(String username, String role);
	
}
