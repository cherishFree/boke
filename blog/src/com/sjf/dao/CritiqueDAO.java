package com.sjf.dao;

import java.util.List;

import com.sjf.fenye.Page;
import com.sjf.po.Critique;

public interface CritiqueDAO {
	//�������
	public void addCritique(Critique critique);
	//��ȡָ��������������
	public int queryCritiqueCount(int AId);
	//����Page����ѯָ�����µ�����
	public List<Critique> queryByPage(int AId, Page page);
}
