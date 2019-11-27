package com.hqyj.JWSystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.JWSystem.system.dao.RolePermissionMapper;
import com.hqyj.JWSystem.system.model.RolePermission;
import com.hqyj.JWSystem.system.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public int deleteRolePermissionByroleid(int roleId) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.deleteRolePermissionByroleid( roleId);
	}

	@Override
	public int addRolePermissionByRolePermission(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.insert(rolePermission);
	}
}
