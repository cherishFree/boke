package com.sjf.dao;

import java.util.List;

import com.sjf.fenye.Page;
import com.sjf.po.Critique;

public interface CritiqueDAO {
	//添加评论
	public void addCritique(Critique critique);
	//获取指定的文章评论数
	public int queryCritiqueCount(int AId);
	//根据Page来查询指定文章的评论
	public List<Critique> queryByPage(int AId, Page page);
}
