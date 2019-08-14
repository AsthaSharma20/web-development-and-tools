/**
 * 
 */
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

/**
 * @author asthasharma
 *
 */

@Entity
public class AddJob {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	
	@Column(name="position")
	private String position;
	
	@Column(name="location")
	private String location;
	
	@Column(name="company")
	private String company;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="aj")
    private Set<Application> applications;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User usr;
	
	
	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}
	public AddJob() {
		
	}
	
	public AddJob(int jobId, String position, String location, String company, String description,
			Set<Application> applications, User usr) {
		super();
		this.jobId = jobId;
		this.position = position;
		this.location = location;
		this.company = company;
		this.description = description;
		this.applications = applications;
		this.usr = usr;
	}
	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
