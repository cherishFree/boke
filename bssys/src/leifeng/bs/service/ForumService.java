package leifeng.bs.service;

import leifeng.bs.base.DaoSupport;
import leifeng.bs.domain.Forum;

public interface ForumService extends DaoSupport<Forum> {

	/** 上移动 */
	void moveUp(Long id);

	/** 下移*/
	void moveDown(Long id);

}
