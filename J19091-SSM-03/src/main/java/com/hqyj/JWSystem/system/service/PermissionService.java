package com.hqyj.JWSystem.system.service;

import java.util.List;

import com.hqyj.JWSystem.system.model.Permission;

public interface PermissionService {

	List<Permission> queryAllPermission();

	List<Permission> queryAllPermissionXZ_By(int roleId);


}
