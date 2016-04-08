package com.sjf.action;


import com.opensymphony.xwork2.ActionSupport;
import com.sjf.po.User;
import com.sjf.service.UserService;

public class Register extends ActionSupport{
	
	private String username;//用户名
	private String password;//密码
	private String repassword;//确认密码
	private String nickname;//昵称
	private String question;//密保问题
	private String answer;//密保答案
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	//输入校验方法
	/*public void validate() {
		if(username==null || "".equals(username.trim())){
			this.addFieldError("username", "用户名不能为空！");
		}
		if(password==null || "".equals(password.trim())){
			this.addFieldError("password", "密码不能为空！");
		}
		if(repassword==null || "".equals(repassword.trim())){
			this.addFieldError("repassword", "确认密码不能为空！");
		}
		if(nickname==null || "".equals(nickname.trim())){
			this.addFieldError("nickname", "昵称不能为空！");
		}
		if(question==null || "".equals(question.trim())){
			this.addFieldError("question", "密保问题不能为空！");
		}
		if(answer==null || "".equals(answer.trim())){
			this.addFieldError("answer", "密保答案不能为空！");
		}			
	}*/
	
	public String execute() throws Exception {
		//封装一个user对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setQuestion(question);
		user.setAnswer(answer);
		
		if(userService.registerUser(user)){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	
}
