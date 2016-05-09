package leifeng.bs.service;

import java.util.List;

import leifeng.bs.base.DaoSupport;
import leifeng.bs.domain.Department;

public interface DepartmentService extends DaoSupport<Department> {


	/**
	 * 查询顶级部门
	 * @return
	 */
	List<Department> findToList();

	/**
	 * 查询子部门列表
	 * @return
	 */
	List<Department> findChildren(Long parentId);

}
