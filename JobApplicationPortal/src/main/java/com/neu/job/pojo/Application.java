package com.neu.job.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Application {


	public Application() {
		
	}
	public Application(int applicationId, String fname, String resume, AddJob aj, User usr, String lname,
			String contactNo, String emailId, String addressLine1, String addressLine2, String city, String zip,
			String country) {
		super();
		this.applicationId = applicationId;
		this.fname = fname;
		this.resume = resume;
		this.aj = aj;
		this.usr = usr;
		this.lname = lname;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationId;
	
	@Column(name="fname")
	private String fname;
	
	
	@Column
	private String resume;
	
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public AddJob getAj() {
		return aj;
	}
	public User getUsr() {
		return usr;
	}



	public void setUsr(User usr) {
		this.usr = usr;
	}



	public void setAj(AddJob aj) {
		this.aj = aj;
	}
	@ManyToOne
    @JoinColumn(name="jobId")
	private AddJob aj;
	
	@ManyToOne
    @JoinColumn(name="userId")
	private User usr;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="addressLine1")
	private String addressLine1;
	
	@Column(name="addressLine2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="country")
	private String country;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	
	
	
	 
	
}
