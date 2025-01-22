package com.tms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="students")
public class Students {
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public Long getStu_id() {
		return stu_id;
	}

	public void setStu_id(Long stu_id) {
		this.stu_id = stu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(LocalDate registration_date) {
		this.registration_date = registration_date;
	}

	public Long getAadhar() {
		return Aadhar;
	}

	public void setAadhar(Long aadhar) {
		Aadhar = aadhar;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stu_id;

    private String name;
    private String email;
    private String  phone_no;
    private String address;
    private LocalDate registration_date;
    private Long Aadhar;
	private String Gender;
	private String password;
    

    @OneToOne(fetch = FetchType.LAZY)  // You can change to EAGER if needed
    @JoinColumn(name="user_id",referencedColumnName = "u_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)  // You can change to EAGER if needed
    @JoinColumn(name="course_id",referencedColumnName = "id")
    private Course course;
    
    @OneToOne(mappedBy = "student")
    private Enrollment enrollment;
    
        
}
