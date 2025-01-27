package com.sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Course;


@Repository
public interface CourseDb extends JpaRepository<Course, Long> {
	Optional<Course> findByCoursename(String coursename);

}
