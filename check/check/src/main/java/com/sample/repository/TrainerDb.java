package com.sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Trainer;


@Repository
public interface TrainerDb extends JpaRepository<Trainer,Long>  {
	 
	Optional<Trainer> findByName(String username);
	 
}
