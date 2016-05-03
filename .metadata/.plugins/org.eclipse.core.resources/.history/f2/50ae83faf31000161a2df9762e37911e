package com.ibeifeng.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ibeifeng.fenye.Page;
import com.ibeifeng.fenye.Result;
import com.ibeifeng.po.Article;
import com.ibeifeng.rss.CreateRss;
import com.ibeifeng.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowRSS extends ActionSupport {
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String execute() throws Exception {
		//通过调用业务逻辑组件来完成查询
		Page page = new Page();
		page.setCurrentPage(0);
		page.setEveryPage(10);
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		//获得文章结果集
		List<Article> all = result.getList();
		
		String filePath = ServletActionContext.getServletContext().getRealPath("/rss.xml");
		
		CreateRss.publishRss(all, filePath);
		return super.execute();
	}

}
