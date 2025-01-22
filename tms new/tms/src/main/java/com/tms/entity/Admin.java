package com.tms.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin {
	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
	private String username;
	private String phone_number;
	private String Address;
	private Long Aadhar;
	private String Gender;
    
	@OneToOne(fetch = FetchType.LAZY)  // You can change to EAGER if needed
	@JoinColumn(name="user_id",referencedColumnName = "u_id")
	private User user;

}
