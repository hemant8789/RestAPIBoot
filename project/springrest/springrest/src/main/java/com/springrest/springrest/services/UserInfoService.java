package com.springrest.springrest.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entites.Userprofile;

import jakarta.persistence.EntityNotFoundException;

public interface UserInfoService {//defines the method that need to be implemented by the classes
	
	public List<Userprofile> getUserInfo();//provide list of user profile
	
	public Optional<Userprofile> getUserprofile(long UserId);//used to retrieve single user profile
	
	public Userprofile addUserprofile(Userprofile profile);//add new user profile to database
	
	public Userprofile updateUserprofile(long userId, Userprofile profile) throws EntityNotFoundException;
	//update an existing user profile
	Userprofile getUserprofile(Long UserId);

	public void deleteUserprofile(Long UserId);//delete a user profile with given user id.
	
}
