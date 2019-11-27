package com.hqyj.JWSystem.system.service;

import java.util.List;

import com.hqyj.JWSystem.system.model.Role;

public interface RoleService {

	List<Role> queryAllRole();

	Role queryRoleById(int id);

	Role queryRoleByRole_id(int roleId);

	
}
