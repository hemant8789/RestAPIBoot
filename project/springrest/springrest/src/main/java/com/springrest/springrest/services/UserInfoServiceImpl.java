package com.springrest.springrest.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Exception.KeyAlreadyExists;
import com.springrest.springrest.dao.UserInfoDao;
import com.springrest.springrest.entites.Userprofile;

import jakarta.persistence.EntityNotFoundException;


@Service 

public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public List<Userprofile> getUserInfo() {
	
		return userInfoDao.findAll() ;
	}


	@SuppressWarnings("deprecation")
	@Override
	public Userprofile getUserprofile(Long UserId) {
		
		return userInfoDao.getOne(UserId) ;
		
	}


	@Override
	public Userprofile addUserprofile(Userprofile profile) {
		
//		list.add(profile);
					
			List<Userprofile> allusers= userInfoDao.findAll();
			allusers.forEach(user -> {
				if(user.getEmailId().equals (profile.getEmailId())) {
					throw new KeyAlreadyExists("duplicate email");
				}
			});
			System.out.println(profile.getRole());
			
		
		userInfoDao.save(profile);
		return profile;
	}
	
	@Override
	public Userprofile updateUserprofile(long userId, Userprofile profile) throws EntityNotFoundException {
		try {			
			boolean exist = userInfoDao.existsById(userId);
			if(!exist) {
				throw new EntityNotFoundException("no such user found");
			}
			profile.setUserId(userId);
			userInfoDao.save(profile);
		} catch (EntityNotFoundException e) {
			// TODO: handle exception
			throw new EntityNotFoundException(e.getMessage());
		}
		return profile;
		
	}
	
	
	@Override
	public void deleteUserprofile(Long UserId) {
			
	Userprofile entity	=userInfoDao.getOne(UserId);
		userInfoDao.delete(entity);
		
	}


	@Override
	public Optional<Userprofile> getUserprofile(long UserId) {
		
		return userInfoDao.findById(UserId); 
	}

	//optional so that the client can check if profile exist or not.	

}
