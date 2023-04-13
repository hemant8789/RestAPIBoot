package com.springrest.springrest.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rolename;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER) 
	private Userprofile userprofile;

	public Role(Long id, String rolename, Userprofile userprofile) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.userprofile = userprofile;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Userprofile getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(Userprofile userprofile) {
		this.userprofile = userprofile;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", userprofile=" + userprofile + "]";
	}
	
	
	
	

}
