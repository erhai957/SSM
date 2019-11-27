package com.hqyj.JWSystem.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.JWSystem.system.dao.PermissionMapper;
import com.hqyj.JWSystem.system.model.Permission;
import com.hqyj.JWSystem.system.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissiosnMapper;

	@Override
	public List<Permission> queryAllPermission() {
		// TODO Auto-generated method stub
		return permissiosnMapper.queryAllPermission();
	}

	@Override
	public List<Permission> queryAllPermissionXZ_By(int roleId) {
		// TODO Auto-generated method stub
		return permissiosnMapper.queryAllPermissionXZ_By(roleId);
	}

	
	
}
