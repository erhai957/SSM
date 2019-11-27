package com.hqyj.JWSystem.system.dao;

import java.util.List;

import com.hqyj.JWSystem.system.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User queryUserByUser(User user);

	List<User> queryAllUser();

	int addUser(User user);

	int deleteUser(int id);

	User queryUserById(int id);

	int addUserByUser(User user);
}