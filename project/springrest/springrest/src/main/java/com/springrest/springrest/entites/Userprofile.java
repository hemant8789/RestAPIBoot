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
	
	@Id	//indicate that UserRoleId is the primary key for the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)//used to specify that the primary key value should be generated automatically.
	private long UserRoleId;
	
	@NotEmpty
	@Size(min = 4, message = "INVALID INPUT!!") 
	private String Name;
	
	@NotEmpty(message = "FORMAT ERROR!!")
	private String DOB;
	
	@NotEmpty(message = "It should not be empty!!")
	private String Education;
	
//	@NotEmpty(message = "Marital status should not be empty!!")
	@NotBlank(message = "sadhi hua nahi kya")
	private String martialStatus;
	
	@NotNull
	private long phoneNumber;
	
//	@UniqueEmail(message = "Duplicate EmailId")
	@Email(message = "FORMAT ERROR!!")
	@NotEmpty(message = "should not be empty")
	@Column(unique = true)
	private String emailId;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userinfo_role_id")
	private Role role;
	
	public Userprofile(long userRoleId, String name, String dOB, String education, String martialStatus,
			long phoneNumber, String emailId) {
		super();
		this.UserRoleId = userRoleId;
		this.Name = name;
		this.DOB = dOB;
		this.Education = education;
		this.martialStatus = martialStatus;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	public Userprofile() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getmartialStatus() {
		return martialStatus;
	}

	public void setmartialStatus(String martialStatus) {
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

	@Override
	public String toString() {
		return "Userprofile [UserRoleId=" + UserRoleId + ", Name=" + Name + ", DOB=" + DOB + ", Education=" + Education
				+ ", martialStatus=" + martialStatus + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
	}
	
	
	

}