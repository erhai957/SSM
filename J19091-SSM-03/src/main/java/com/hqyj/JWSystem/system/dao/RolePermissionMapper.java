package com.hqyj.JWSystem.system.dao;

import com.hqyj.JWSystem.system.model.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

	int deleteRolePermissionByroleid(int roleId);
}