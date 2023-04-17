package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entites.Userprofile;

public interface UserInfoDao extends JpaRepository<Userprofile, Long> {
	
}
