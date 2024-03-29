package com.sjf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sjf.fenye.Result;
import com.sjf.po.Article;
import com.sjf.po.BlogInfo;
import com.sjf.service.ArticleService;
import com.sjf.service.BlogInfoService;

public class UpdateArticle extends ActionSupport{
	private int id;
	private String title;
	private String content;
	private int hasread;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHasread() {
		return hasread;
	}
	public void setHasread(int hasread) {
		this.hasread = hasread;
	}
	private ArticleService articleService;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	

		
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		//��id��ѯ����
		Article article = articleService.showArticle(id);
		
		request.setAttribute("article", article);
		System.out.println("article="+article);
		
		return this.SUCCESS;
	}
	
	

}
