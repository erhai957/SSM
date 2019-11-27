package com.hqyj.JWSystem.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.JWSystem.system.dao.RoleMapper;
import com.hqyj.JWSystem.system.model.Role;
import com.hqyj.JWSystem.system.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> queryAllRole() {
		// TODO Auto-generated method stub
		return roleMapper.queryAllRole();
	}

	@Override
	public Role queryRoleById(int id) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleById(id);
	}

	@Override
	public Role queryRoleByRole_id(int roleId) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(roleId);
	}

	
	
}
