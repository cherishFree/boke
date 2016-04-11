package com.sjf.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sjf.po.User;
import com.sjf.service.UserService;

public class Login extends ActionSupport {
	private String username;
	private String password;
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		

		//获得request
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(userService.loginUser(user)){
			request.setAttribute("url", "user/getBlogInfo.action");
			request.setAttribute("info", "登陆成功");
			//将用户名保存到session范围中
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
			
			Map session =ActionContext.getContext().getSession();
			session.put("username", username);
			return SUCCESS;
		}else{
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "登陆失败");			
			return ERROR;
		}
	}

	
	
}
