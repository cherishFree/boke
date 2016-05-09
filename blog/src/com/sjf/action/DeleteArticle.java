package com.sjf.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sjf.po.Article;
import com.sjf.service.ArticleService;

public class DeleteArticle extends ActionSupport{
	
	private int id;
	
    private ArticleService articleService;
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	//���request
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		if(username == null  || "".equals(username)){
			//request.setAttribute("msg", "ɾ�����ִ��󣡣�");
			return this.ERROR;
		}else{
			articleService.delete(id);
			//request.setAttribute("msg", "ɾ���ɹ���");
			return this.SUCCESS;
		}
		
	}
	
	//=======���ݷ�װ========
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
