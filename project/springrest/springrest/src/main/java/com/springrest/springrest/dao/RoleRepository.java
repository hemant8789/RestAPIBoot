package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entites.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
