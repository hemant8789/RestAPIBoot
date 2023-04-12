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
	
	
//	List<Userprofile> list;
	
	public UserInfoServiceImpl() {
		
//		list= new ArrayList<>();
//		list.add(new Userprofile(001,"Hemant","17011998","engineering","Single",8789072,"hemant5@gmail.com"));
//		list.add(new Userprofile(002,"shubhankar","08112000","b.com","Single",843432,"shubhankar12@gmail.com"));

		
	
	
	}
	
	
	@Override
	public List<Userprofile> getUserInfo() {
	
		
		return userInfoDao.findAll() ;
	}


	@SuppressWarnings("deprecation")
	@Override
	public Userprofile getUserprofile(Long UserId) {
		
//		Userprofile c= null;
//		for(Userprofile User: list)
//		{
//			if(User.getUserRoleId()==UserId)
//			{
//				
//				c= User;
//				break;
//			}
//			
//		}
		
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
			System.out.println(profile.getmartialStatus());
			
			userInfoDao.save(profile);
		} catch (KeyAlreadyExistsException e) {
			// TODO: handle exception
			throw new KeyAlreadyExistsException(e.getMessage());
		}
		return profile;
	}
	
	@Override
	public Userprofile updateUserprofile(Userprofile profile) {
		
//		list.forEach(e -> {
//			
//			if(e.getUserRoleId() == profile.getUserRoleId()) {
//				e.setName(profile.getName());
//				e.setEducation(profile.getEducation());
//			}
//		});
		
		
		userInfoDao.save(profile);
		return profile;
		
	}
	
	
	@Override
	public void deleteUserprofile(Long UserId) {
		
//	list= this.list.stream().filter(e->e.getUserRoleId()!=parseInteger).collect(Collectors.toList());
	
	Userprofile entity	=userInfoDao.getOne(UserId);
		userInfoDao.delete(entity);
		
	}


	@Override
	public Optional<Userprofile> getUserprofile(long UserId) {
		// TODO Auto-generated method stub
		return userInfoDao.findById(UserId);
	}


//	@Override
//	public void deleteUserprofile(Integer parseInteger) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	
	

}