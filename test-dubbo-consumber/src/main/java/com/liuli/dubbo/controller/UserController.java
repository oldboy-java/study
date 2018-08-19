package com.liuli.dubbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuli.dubbo.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	@RequestMapping("/hello")
	@ResponseBody
    public String sayHello(){
      return userService.sayHello();
    }
}
