package com.sjf.service;

import com.sjf.dao.UserDAO;
import com.sjf.po.User;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean registerUser(User user) {
		//判断用户是否存在
		if(userDAO.queryByID(user.getUsername()) != null){
			return false;//表示没有用户 
		}else{
			userDAO.add(user);//保存用户
			return true;//表示用户注册成功
		}
	}

	public boolean loginUser(User user) {
		//判断用户是否存在
		if(userDAO.queryByID(user.getUsername()) == null){
			return false;		
		}else{
			User queryuser =userDAO.queryByID(user.getUsername());
			if(queryuser.getPassword().equals(user.getPassword())){
				return true;
			}else{
				return false;
			}
		}
	}
	
}
