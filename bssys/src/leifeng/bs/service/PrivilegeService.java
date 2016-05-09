package leifeng.bs.service;

import java.util.Collection;
import java.util.List;

import leifeng.bs.base.DaoSupport;
import leifeng.bs.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege> {

	/**
	 * 查询所有的顶级权限
	 * @return
	 */
	List<Privilege> findTopList();
	
    /**
     * 查询出数据库中所有权限的url
     * @return
     */
	Collection<String> getAllPrivilegeUrls();

}
