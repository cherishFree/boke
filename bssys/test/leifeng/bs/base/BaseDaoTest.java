package leifeng.bs.base;

import org.junit.Test;
import leifeng.bs.dao.RoleDao;
import leifeng.bs.dao.UserDao;
import leifeng.bs.dao.impl.RoleDaoImpl;
import leifeng.bs.dao.impl.UserDaoImpl;
import leifeng.bs.domain.Department;

public class BaseDaoTest {

	@Test
	public void testSave(){
		
		UserDao userDao=new UserDaoImpl();
		RoleDao roleDao=new RoleDaoImpl();
		
		Department department=new Department();
		//userDao.save(entity);
		
		
	}

}
