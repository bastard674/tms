package com.tms.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
	public Long getU_id() {
		return u_id;
	}
	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long u_id;
	private String user_type;
	private String user_name;
	private String password;
	
	  @OneToOne(mappedBy = "user") // Non-owning side, references `student` in Enrollment
	    private Trainer trainer;
	  @OneToOne(mappedBy = "user") // Non-owning side, references `student` in Enrollment
	    private Students student;
	  @OneToOne(mappedBy = "user") // Non-owning side, references `student` in Enrollment
	    private Admin admin;
}
