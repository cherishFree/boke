package com.sjf.service;

import java.util.List;

import com.sjf.fenye.Page;
import com.sjf.fenye.Result;
import com.sjf.po.Article;

public interface ArticleService {
	//进行文章的保存
	public void addArticle(Article article);
	//取出所有用户的文章
	public List<Article> showUserAllArticle(String username);
	//分页显示用户文章
	public Result showUserArticleByPage(String username,Page page);
	//分页显示全部文章
	public Result showArticleByPage(Page page);
	//显示文章
	public Article showArticle(int id);
	//获得评论数
	public int getCritiqueCount(int AId);
	
}
