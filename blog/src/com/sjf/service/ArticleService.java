package com.sjf.service;

import java.util.List;

import com.sjf.fenye.Page;
import com.sjf.fenye.Result;
import com.sjf.po.Article;

public interface ArticleService {
	//�������µı���
	public void addArticle(Article article);
	//ȡ�������û�������
	public List<Article> showUserAllArticle(String username);
	//��ҳ��ʾ�û�����
	public Result showUserArticleByPage(String username,Page page);
	//��ҳ��ʾȫ������
	public Result showArticleByPage(Page page);
	//��ʾ����
	public Article showArticle(int id);
	//���������
	public int getCritiqueCount(int AId);
	
}
