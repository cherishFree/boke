package com.sjf.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sjf.po.DianJiLiang;

public class DianJiLiangDAOImpl extends HibernateDaoSupport implements DianJiLiangDAO {

	public List queryByAId(final int AId, final String IP, final Date time) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select djl from DianJiLiang djl where djl.AId=?and djl.ip=?and djl.time=?");
				//���ò���a
				query.setParameter(0, AId);
				query.setParameter(1, IP);
				query.setParameter(2, time);
				return query.list();
			}
		
		});
	}

	public void addJilu(DianJiLiang dianjiliang) {
		this.getHibernateTemplate().save(dianjiliang);
	}

}
