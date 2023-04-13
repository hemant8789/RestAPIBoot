package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.UserInfoDao;
import com.springrest.springrest.entites.Userprofile;


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
		try {			
			List<Userprofile> allusers= userInfoDao.findAll();
			allusers.forEach(user -> {
				if(user.getEmailId().equals (profile.getEmailId())) {
					throw new KeyAlreadyExistsException("duplicate email");
				}
			});
			System.out.println(profile.getRole());
			profile.getRole().setUserprofile(profile);
			
			
			userInfoDao.save(profile);
		} catch (KeyAlreadyExistsException e) {
			
			throw new KeyAlreadyExistsException(e.getMessage());
		}
		return profile;
	}
	
	@Override
	public Userprofile updateUserprofile(Userprofile profile) {
		
		userInfoDao.save(profile);
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

		

}
