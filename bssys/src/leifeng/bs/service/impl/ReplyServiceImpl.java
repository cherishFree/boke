package leifeng.bs.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import leifeng.bs.base.DaoSupportImpl;
import leifeng.bs.domain.Forum;
import leifeng.bs.domain.PageBean;
import leifeng.bs.domain.Reply;
import leifeng.bs.domain.Topic;
import leifeng.bs.service.ReplyService;

@Service
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {

	/** 查询指定主题中所有的回复列表,排序，按发表时间排序，升序 */
	@Override
	public List<Reply> findByTopic(Topic topic) {
		return getSession().createQuery(//
				"FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC")//
				.setParameter(0, topic)
				.list();
	}
	
	/**重写save()方法 */
	public void save(Reply reply){
		//保存
		getSession().save(reply);
		//2.维护相关的信息
		Topic topic=reply.getTopic();
		Forum forum=topic.getForum();
		
		
		forum.setArticleCount(forum.getArticleCount()+1);
		topic.setReplyCount(topic.getReplyCount()+1);//回复数量
		topic.setLastReply(reply);//最后发表的回复
		topic.setLastUpdateTime(reply.getPostTime());//最后更新的时间（主题发表的时间）
		
		getSession().update(topic);
		getSession().update(forum);
	}

	/**
	 * 查询当前页信息  v1
	 */
	/*@Override
	public PageBean getPageBeanByTopic(int pageNum, int pageSize, Topic topic) {
		//查询列表
		List list= getSession().createQuery(//
				"FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC")//
				.setParameter(0, topic)
				.setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		//查询总数量
		Long count=(Long)getSession().createQuery(//
				"SELECT COUNT(*) FROM Reply r WHERE r.topic=?")//
				.setParameter(0, topic)//
				.uniqueResult();
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}*/

}
