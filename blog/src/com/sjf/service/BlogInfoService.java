package com.sjf.service;

import com.sjf.po.BlogInfo;

public interface BlogInfoService {
	
	//���ò��͸��Ի�����
	public void setBlogInfo(BlogInfo blogInfo);
	
	//��ò��͸��Ի�����
	public BlogInfo getBlogInfo(String name);
	
}
