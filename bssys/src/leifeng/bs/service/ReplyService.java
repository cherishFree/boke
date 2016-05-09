package leifeng.bs.service;

import java.util.List;

import leifeng.bs.base.DaoSupport;
import leifeng.bs.domain.PageBean;
import leifeng.bs.domain.Reply;
import leifeng.bs.domain.Topic;

public interface ReplyService extends DaoSupport<Reply> {

	/**
	 * 查询指定主题中所有的回复列表,排序，按发表时间排序，升序
	 * @param topic
	 * @return
	 */
	List<Reply> findByTopic(Topic topic);

	/**
	 * 查询分页信息 v1
	 * @param pageNum
	 * @param pageSize
	 * @param topic
	 * @return
	 */
	//PageBean getPageBeanByTopic(int pageNum, int pageSize, Topic topic);

}
