package com.tms.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

	Optional<Course> findByCoursename(String coursename);

}
