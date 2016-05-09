package leifeng.bs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leifeng.bs.base.DaoSupportImpl;
import leifeng.bs.domain.Forum;
import leifeng.bs.domain.PageBean;
import leifeng.bs.domain.Topic;
import leifeng.bs.service.TopicService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {

	/**  查询所有板块中所有主题，排序：所有置顶贴在最上面,并按最后更新时间排序，然新状态的在上面  */
	@Override
	public List<Topic> findByForum(Forum forum) {
		return getSession().createQuery(//
				//排序：所有制定贴在最上面，并按最后更新的时间排序，让新状态的在上面
				//TODO 怎么样排序？？
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)
				.list();
	}
	
	public void save(Topic topic){
		//>>应该放到业务方法中
		topic.setType(Topic.TYPE_NORMAL);//默认为普通帖
		topic.setReplyCount(0);
		topic.setLastReply(null);
		topic.setLastUpdateTime(topic.getPostTime());
		getSession().save(topic);
		
		//2.维护相关的特殊属性
		Forum forum=topic.getForum();
		forum.setTopicCount(forum.getTopicCount()+1);//主题数量
		forum.setArticleCount(forum.getArticleCount()+1);//文章数量
		forum.setLastTopic(topic);//最后发表的主题
		getSession().update(forum);
		
	}

	/*@Override
	public PageBean getPageBeanByForm(int pageNum, int pageSize, Forum forum) {
		//查询列表
		List list= getSession().createQuery(//
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)
				.setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		//查询总数量
		Long count=(Long)getSession().createQuery(//
				"SELECT COUNT(*) FROM Topic t WHERE t.forum=?")//
				.setParameter(0, forum)//
				.uniqueResult();
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}*/

}
