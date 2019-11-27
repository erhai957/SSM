package com.hqyj.JWSystem.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.JWSystem.system.dao.UserMapper;
import com.hqyj.JWSystem.system.model.User;
import com.hqyj.JWSystem.system.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	
	public User queryUserByUser(User user) {
		return userMapper.queryUserByUser(user);
	}


	@Override
	public List<User> queryAllUser() {
		
		return userMapper.queryAllUser();
	}


	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}


	@Override
	public int deleteUser(int id) {
		return userMapper.deleteUser(id);
	}


	@Override
	public User queryUserById(int id) {
		return userMapper.queryUserById(id);
	}


	public int addUserByUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUserByUser(user);
	}


	



	
	
}
