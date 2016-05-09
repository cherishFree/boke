package leifeng.bs.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leifeng.bs.base.DaoSupportImpl;
import leifeng.bs.domain.Forum;
import leifeng.bs.service.ForumService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService {

	
	public List<Forum> findAll(){
		return getSession().createQuery(//
				"FROM Forum f ORDER BY f.position")//
				.list();
	}
	
	/**
	 * 重写save方法，解决position位置存储内容
	 */
	public void save(Forum forum){
		//保存
		super.save(forum);
		//设置position的值
		forum.setPosition(forum.getId().intValue());
	}
	
	@Override
	public void moveUp(Long id) {
		//找出相关的Forum
		Forum forum=getById(id);//当前要移动的Forum
		Forum other=(Forum)getSession().createQuery(//我上面的那个Forum
				"FROM Forum f WHERE f.position<? ORDER BY f.position DESC ")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		//最上面的不能上移
		if(other==null){
			return;
		}
		
		//交换position值
		int temp=forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		
		//更新到数据库，可以不写，因为对象现在是持久化状态
		getSession().update(forum);
		getSession().update(other);
		
	}

	@Override
	public void moveDown(Long id) {
		//找出相关的Forum
		Forum forum=getById(id);//当前要移动的Forum
		Forum other=(Forum)getSession().createQuery(//我上面的那个Forum
				"FROM Forum f WHERE f.position<? ORDER BY f.position ASC ")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		//最上面的不能上移
		if(other==null){
			return;
		}
		
		//交换position值
		int temp=forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		
		//更新到数据库，可以不写，因为对象现在是持久化状态
		getSession().update(forum);
		getSession().update(other);
		
	}

}
