package com.springrest.springrest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entites.Userprofile;
import com.springrest.springrest.services.UserInfoService;

import jakarta.validation.Valid;

@RestController			
public class Mycontroller {
	
	
	@Autowired	
	
	private UserInfoService profile;
	
	
//	created the Api  just for testing purpose
//	
//	@GetMapping("/home")
//	public String home() {
//		return "Welcome to User Profile Applications";
//		
//	}
	
	//get the user profile information
	
	
	@GetMapping("/UserInfo")
	
	public List<Userprofile> getUserInfo(){
		
		return this.profile.getUserInfo();
		
		
	}
	
	//single profile get
	
	@GetMapping("/UserInfo/{UserId}")
	public Optional<Userprofile> getUserprofile(@PathVariable String UserId )
	{
		return this.profile.getUserprofile(Long.parseLong(UserId));
	}
	
	
	//User profile add
	
	@PostMapping("/UserInfo")
	public Userprofile addUserprofile(@RequestBody Userprofile profile)
	{
		System.out.println(profile);
		
		return this.profile.addUserprofile(profile);
		
		
	}
	
	//update profile using PUT method
	
	@PutMapping("/UserInfo/{UserId}")
	public Userprofile updateUserprofile(@Valid @RequestBody Userprofile profile)
	{
		
		return this.profile.updateUserprofile(profile);
	}
	
	
	//delete the User Profile
	
	@DeleteMapping("/UserInfo/{UserId}")
	public ResponseEntity<HttpStatus> deleteUserprofile(@PathVariable String UserId  ){
		
		try {
			this.profile.deleteUserprofile(Long.parseLong(UserId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
