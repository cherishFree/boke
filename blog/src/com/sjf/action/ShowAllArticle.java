package com.sjf.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sjf.fenye.Page;
import com.sjf.fenye.Result;
import com.sjf.po.Article;
import com.sjf.service.ArticleService;
import com.sjf.service.CritiqueService;

public class ShowAllArticle extends ActionSupport{
	public ArticleService articleService;
	public int currentPage;
	
 	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String execute() throws Exception {
		//通过调用业务逻辑组件来完成查询
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(10);
		
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		List<Article> all = result.getList();
		
		//把查询到的结果存在一个范围，request
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("all", all);
		request.setAttribute("page", page);
		
		return this.SUCCESS;
	}
	
	
}
