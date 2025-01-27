package com.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.entity.Course;
import com.sample.entity.Students;


@Repository
public interface Remo extends JpaRepository<Students, Long> {
	List<Students> findByStatus(String status);
    List<Students> findByCourse(Course course);
    List<Students> findByStatusAndCourse(String status, Course course);
}