package com.springrest.springrest.entites;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;

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
	private long UserRoleId;
	
	@NotEmpty
	@Size(min = 4, message = "INVALID INPUT!!") 
	private String Name;
	
	@NotEmpty(message = "FORMAT ERROR!!")
	private String DOB;
	
	@NotEmpty(message = "It should not be empty!!")
	private String Education;
	
//	@NotEmpty(message = "Marital status should not be empty!!")
	@NotBlank(message = "Should not be empty")
	private String martialStatus;
	
	@NotNull
	private long phoneNumber;
	
//	@UniqueEmail(message = "Duplicate EmailId")
	@Email(message = "FORMAT ERROR!!")
	@NotEmpty(message = "should not be empty")
	@Column(unique = true)
	private String emailId;
	
	
	@OneToOne(mappedBy = "userprofile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Role role;

	public Userprofile(long userRoleId, @NotEmpty @Size(min = 4, message = "INVALID INPUT!!") String name,
			@NotEmpty(message = "FORMAT ERROR!!") String dOB,
			@NotEmpty(message = "It should not be empty!!") String education,
			@NotBlank(message = "Should not be empty") String martialStatus, @NotNull long phoneNumber,
			@Email(message = "FORMAT ERROR!!") @NotEmpty(message = "should not be empty") String emailId, Role role) {
		super();
		this.UserRoleId = userRoleId;
		this.Name = name;
		this.DOB = dOB;
		this.Education = education;
		this.martialStatus = martialStatus;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Userprofile [UserRoleId=" + UserRoleId + ", Name=" + Name + ", DOB=" + DOB + ", Education=" + Education
				+ ", martialStatus=" + martialStatus + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", role=" + role + "]";
	}

	public long getUserRoleId() {
		return UserRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		UserRoleId = userRoleId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
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

	public Userprofile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
