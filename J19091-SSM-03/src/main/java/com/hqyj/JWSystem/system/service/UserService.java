package com.hqyj.JWSystem.system.service;

import java.util.List;

import com.hqyj.JWSystem.system.model.User;

public interface UserService {
	User queryUserByUser(User user);

	List<User> queryAllUser();

	int addUser(User user);

	int deleteUser(int id);

	User queryUserById(int id);

	int addUserByUser(User user);

}
