package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entites.Userprofile;

public interface UserInfoService {
	
	public List<Userprofile> getUserInfo();
	
	public Optional<Userprofile> getUserprofile(long UserId);
	
	public Userprofile addUserprofile(Userprofile profile);
	
	public Userprofile updateUserprofile(Userprofile profile);
	
//	public void deleteUserprofile(Integer parseInteger);

	Userprofile getUserprofile(Long UserId);

	public void deleteUserprofile(Long UserId);
	
}