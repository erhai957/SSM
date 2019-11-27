package com.hqyj.JWSystem.system.service;

import com.hqyj.JWSystem.system.model.RolePermission;

public interface RolePermissionService {

	int deleteRolePermissionByroleid(int roleId);

	int addRolePermissionByRolePermission(RolePermission rolePermission);

}
