package com.springrest.springrest.controller;


import java.nio.file.attribute.UserPrincipalNotFoundException;
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

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController			
public class UserManagementController {
	
	
	@Autowired	
	
	private UserInfoService profile;
	
	@GetMapping("/UserInfo")
	
	public List<Userprofile> getUserInfo(){
		
		return this.profile.getUserInfo();
		
	}
	
		
	@GetMapping("/UserInfo/{UserId}")
	public Optional<Userprofile> getUserprofile(@PathVariable String UserId )
	{
		return this.profile.getUserprofile(Long.parseLong(UserId));
	}
	
		
	@PostMapping("/UserInfo")
	public Userprofile addUserprofile(@Valid @RequestBody Userprofile profile)
	{
		System.out.println(profile);
		
		return this.profile.addUserprofile(profile);
		
		
	}
		
	@PutMapping("/UserInfo/{UserId}")
	public Userprofile updateUserprofile(@PathVariable("UserId") long userId, @Valid @RequestBody Userprofile profile) throws EntityNotFoundException
	{
		System.out.println(userId);
		
		
		return this.profile.updateUserprofile(userId, profile);
	}
		
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
