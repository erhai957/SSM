package com.hqyj.JWSystem.system.dao;

import com.hqyj.JWSystem.system.model.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

	int deleteUserRoleById(int id);
}