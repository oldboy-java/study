package com.liuli.dubbo.service.impl;

import org.springframework.stereotype.Service;

import com.liuli.dubbo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public String sayHello() {
		return "Hello!!";
	}


}
