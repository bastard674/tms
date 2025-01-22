package com.tms.entity;

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
@Table(name="trainer")
public class Trainer {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	private String age;
	private String phone_no;
	private String address;
	private Long Aadhar;
	private String Gender; 
	
	 @OneToOne(fetch = FetchType.LAZY)  // You can change to EAGER if needed
	 @JoinColumn(name="user_id",referencedColumnName = "u_id")
	 private User user;
	 
	 @OneToOne(fetch = FetchType.LAZY)  // You can change to EAGER if needed
	 @JoinColumn(name="course_id",referencedColumnName = "id")
	 private Course course;
	
	

}
