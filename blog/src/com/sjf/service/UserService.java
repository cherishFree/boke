package com.sjf.service;

import com.sjf.po.User;

public interface UserService {
	//�û�ע��
	public boolean registerUser(User user);
	//�û���¼
	public boolean loginUser(User user);
}
