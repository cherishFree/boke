package com.sjf.service;

import com.sjf.fenye.Page;
import com.sjf.fenye.Result;
import com.sjf.po.Critique;

public interface CritiqueService {
	//�������
	public void addCritique(Critique critique);
	//��ҳ��ʾ����
	public Result showCritiqueByPage(int AId,Page page);
	
}
