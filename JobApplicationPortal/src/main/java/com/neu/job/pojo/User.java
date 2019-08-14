
package com.neu.job.pojo;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(name="Role")
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(name= "Uname")
	private String username;
	
	@Column(name= "Password")
	private String password;
	
	
	@OneToMany(mappedBy="usr")
    private Set<Application> applications;
	
	@OneToMany(mappedBy="usr")
	private Set<AddJob> adjs;
	
	
	public Set<AddJob> getAdjs() {
		return adjs;
	}
	public void setAdjs(Set<AddJob> adjs) {
		this.adjs = adjs;
	}
	public Set<Application> getApplications() {
		return applications;
	}
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	public User() {
		
	}
	
	
	public User(long userId, String role, String username, String password, Set<Application> applications,
			Set<AddJob> adjs) {
		super();
		this.userId = userId;
		this.role = role;
		this.username = username;
		this.password = password;
		this.applications = applications;
		this.adjs = adjs;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
