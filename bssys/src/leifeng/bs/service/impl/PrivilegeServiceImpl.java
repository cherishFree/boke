package leifeng.bs.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leifeng.bs.base.DaoSupportImpl;
import leifeng.bs.domain.Privilege;
import leifeng.bs.service.PrivilegeService;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {
	/** 查询所有的顶级内容 **/
	@Override
	public List<Privilege> findTopList() {
		return getSession().createQuery(//
				"FROM Privilege p WHERE p.parent IS NULL")//
				.list();
	}

	/**
	 * 查询出所有权限的url地址
	 */
	@Override
	public Collection<String> getAllPrivilegeUrls() {
		return getSession().createQuery(//
				"SELECT DISTINCT p.url From Privilege p WHERE p.url IS NOT NULL")//
				.list();
	}

}
