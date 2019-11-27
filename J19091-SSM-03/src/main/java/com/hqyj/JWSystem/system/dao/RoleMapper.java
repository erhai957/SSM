package com.hqyj.JWSystem.system.dao;

import java.util.List;

import com.hqyj.JWSystem.system.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	List<Role> queryAllRole();

	Role queryRoleById(int id);
}