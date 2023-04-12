package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.RoleRepository;
import com.springrest.springrest.entites.Role;

@Service
public class RoleServiceImpl  implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@SuppressWarnings("deprecation")
	@Override
	public Role getRoleById(Long id) {
		
		return roleRepository.findById(id).orElse(null);
		
	}
	
	@Override
	public Role addRole(Role role) {
		
		return roleRepository.save(role);
	}
	
	@Override
	public Role updateRole(Long id, Role role) {
		
		Role existingRole = roleRepository.findById(id).orElse(null);
		if(existingRole != null) {
			existingRole.setRolename(role.getRolename());
			roleRepository.save(existingRole);
		}
		return existingRole;
	}
	
	@Override
	public void deleteRole(Long id) {
		
		Role entity= roleRepository.findById(id).orElse(null);
		if(entity != null) {
			roleRepository.delete(entity);
		}
		roleRepository.delete(entity);
	}
	
	@Override
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
		
	}

	
	
}
