package com.hqyj.JWSystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.JWSystem.system.dao.UserRoleMapper;
import com.hqyj.JWSystem.system.model.UserRole;
import com.hqyj.JWSystem.system.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public int deleteUserRoleById(int id) {
		return userRoleMapper.deleteUserRoleById(id);
	}

	@Override
	public int addUserRoleByUserRole(UserRole userRole) {
		return userRoleMapper.insertSelective(userRole);
	}
}
