package com.sample.entity;
import javax.persistence.*;

import com.sample.entity.Course;

@Entity
@Table(name="Students")
public class Students {

    public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)  // You can change to EAGER if needed
    @JoinColumn(name="course_id",referencedColumnName = "id")
    private Course course;
    
    @OneToOne
    @JoinColumn(name = "user_id")  // Foreign key column in the Admin table
    private Users user;
    

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false)
    private String status = "pending";
    
    private String password;

    // Getters and Setters
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
