package com.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="enrollment")
public class Enrollment {
	
	public Long getE_id() {
		return e_id;
	}

	public void setE_id(Long e_id) {
		this.e_id = e_id;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long e_id;
	
	@OneToOne
	@JoinColumn(name="student_id",referencedColumnName="stu_id")
	private Students student;
	
	@ManyToOne
	@JoinColumn(name="course_id",referencedColumnName="id")
	private Course course;
	
	
    private String status;
	
	
	

}
