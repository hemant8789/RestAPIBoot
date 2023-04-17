package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entites.Role;
import com.springrest.springrest.services.RoleService;

import jakarta.validation.Valid;

@RestController
public class RoleManagementController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/role/{id}")
	public Role getRoleById(@PathVariable Long id) {
		return this.roleService.getRoleById(id);
	}
	
	@PostMapping("/role")
	public String addRole(@Valid @RequestBody Role role) {
		System.out.println(role);
		
		return this.roleService.addRole(role);
		}
	
	@PutMapping("/role/{role_id}")
	
	public ResponseEntity<Role> updateRole(@PathVariable Long role_id, @Valid @RequestBody Role role){
		return ResponseEntity.ok(this.roleService.updateRole(role_id, role));
	}
	
	
	
	
	
}
