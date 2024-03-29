package com.sjf.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.sjf.po.BlogInfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO{

	public void save(BlogInfo info) {
		this.getHibernateTemplate().saveOrUpdate(info);//既可以实现save()功能，也可以实现update()功能；
	}

	public BlogInfo get(String username) {
		List list =  this.getHibernateTemplate().find("select bloginfo from BlogInfo bloginfo where bloginfo.username=?",username);
		if(list.size() == 0){
			return null;
		}else{
			return (BlogInfo) list.get(0);
					
		}
	}

}
