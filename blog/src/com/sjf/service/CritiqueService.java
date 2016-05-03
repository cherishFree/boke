package com.sjf.service;

import com.sjf.fenye.Page;
import com.sjf.fenye.Result;
import com.sjf.po.Critique;

public interface CritiqueService {
	//添加评论
	public void addCritique(Critique critique);
	//分页显示评论
	public Result showCritiqueByPage(int AId,Page page);
	
}
