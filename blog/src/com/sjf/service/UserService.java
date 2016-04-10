package com.sjf.service;

import com.sjf.po.User;

public interface UserService {
	//用户注册
	public boolean registerUser(User user);
	//用户登录
	public boolean loginUser(User user);
}
