package com.sjf.dao;

import java.util.Date;
import java.util.List;

import com.sjf.po.DianJiLiang;

public interface DianJiLiangDAO {

	//���ظ����£���IP����ʱ��ķ��ʼ�¼
	public List queryByAId(int AId,String IP,Date time);
	
	//���ӷ��ʼ�¼
	public void addJilu(DianJiLiang dianjiliang);
}