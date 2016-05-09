package leifeng.bs.service;

import java.util.List;

import leifeng.bs.base.DaoSupport;
import leifeng.bs.domain.Forum;
import leifeng.bs.domain.PageBean;
import leifeng.bs.domain.Topic;

public interface TopicService extends DaoSupport<Topic>{

	/** 
	 * 查询所有板块中所有主题，排序：所有置顶贴在最上面,并按最后更新时间排序，然新状态的在上面
	 * @param forum
	 * @return
	 */
	List<Topic> findByForum(Forum forum);

	/**
	 * 主题列表分页信息 v1
	 * @param pageNum
	 * @param pageSize
	 * @param forum
	 * @return
	 */
	///PageBean getPageBeanByForm(int pageNum, int pageSize, Forum forum);

}
