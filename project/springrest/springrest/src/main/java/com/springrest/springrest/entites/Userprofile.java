package com.springrest.springrest.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Userprofile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@NotEmpty
	@Size(min = 4, message = " Name field Should not be Empty!!")
	private String name;
	
	@NotEmpty(message = "Please enter DOB")
	private String dob;
	
	@NotEmpty(message = "It should not be empty!!")
	private String education;
	
	@NotBlank(message = "should not be empty!!")
	private String martialStatus;
	
	@NotNull
	private long phoneNumber;
	

	@Email(message = "FORMAT ERROR!!")
	@NotEmpty(message = "Should not be empty!!")
	@Column
	private String emailId;

	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Role role;


	public Userprofile(long userId, @NotEmpty @Size(min = 4, message = "INVALID INPUT!!") String name,
			@NotEmpty(message = "FORMAT ERROR!!") String dob,
			@NotEmpty(message = "It should not be empty!!") String education,
			@NotBlank(message = "should not be empty!!") String martialStatus, @NotNull long phoneNumber,
			@Email(message = "FORMAT ERROR!!") @NotEmpty(message = "Should not be empty!!") String emailId, Role role) {
		super();
		this.userId = userId;
		this.name = name;
		this.dob = dob;
		this.education = education;
		this.martialStatus = martialStatus;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Userprofile [userId=" + userId + ", name=" + name + ", dob=" + dob + ", education=" + education
				+ ", martialStatus=" + martialStatus + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", role=" + role + "]";
	}

	public Userprofile() {
		super();
		
	}


	public Userprofile(long userId2, String name2, String dob2, String education2, String martialStatus2,
			long phoneNumber2, String emailId2, String string) {
		// TODO Auto-generated constructor stub
	}

	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name != null ? name : "";
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getMartialStatus() {
		return martialStatus;
	}


	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

}
