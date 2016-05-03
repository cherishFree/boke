package com.sjf.dao;

import java.util.Date;
import java.util.List;

import com.sjf.po.DianJiLiang;

public interface DianJiLiangDAO {

	//返回该文章，该IP，该时间的访问记录
	public List queryByAId(int AId,String IP,Date time);
	
	//添加访问记录
	public void addJilu(DianJiLiang dianjiliang);
}
