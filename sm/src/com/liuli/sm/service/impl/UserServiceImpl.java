package com.liuli.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuli.sm.mappers.UserMapper;
import com.liuli.sm.pojo.User;
import com.liuli.sm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper UserMapper;
	
	@Override
	@Transactional
	public int addUser(User user) {
		int insert = UserMapper.addUser(user);
		int a = 9 / 0;
		return insert;
	}

}
