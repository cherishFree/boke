package leifeng.bs.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leifeng.bs.base.DaoSupportImpl;
import leifeng.bs.domain.User;
import leifeng.bs.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		//使用MD5摘要进行对比
		String md5Digest=DigestUtils.md5Hex(password);
		return (User)getSession().createQuery(//
				"FROM User u WHERE u.loginName=? and u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5Digest)//
				.uniqueResult();
	}

}
