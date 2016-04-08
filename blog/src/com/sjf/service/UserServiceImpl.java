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
		//�ж��û��Ƿ����
		if(userDAO.queryByID(user.getUsername()) != null){
			return false;//��ʾû���û� 
		}else{
			userDAO.add(user);//�����û�
			return true;//��ʾ�û�ע��ɹ�
		}
	}
	
}