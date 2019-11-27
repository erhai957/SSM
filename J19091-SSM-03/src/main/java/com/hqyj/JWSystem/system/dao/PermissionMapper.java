package com.hqyj.JWSystem.system.dao;

import java.util.List;

import com.hqyj.JWSystem.system.model.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

	List<Permission> queryAllPermission();

	List<Permission> queryAllPermissionXZ_By(int roleId);
}