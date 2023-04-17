package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entites.Role;

public interface RoleService {
	
	public Role getRoleById(Long id);
	
	public String addRole(Role role);
	
	public Role updateRole(Long id, Role role);
	
	public void deleteRole(Long id);
	
	public List<Role> getAllRoles();
}
