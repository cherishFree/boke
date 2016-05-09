package leifeng.bs.base;

import java.util.List;

import leifeng.bs.domain.PageBean;
import leifeng.bs.util.QueryHelper;

public interface DaoSupport<T> {
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	/**
	 * 按id查询
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 公共分页查询
	 * @param pageNum 当前页
	 * @param pageSize 每页显示的条数
	 * @param sql 查询语句HQL语句
	 * @param parameters  参数列表，其中的顺序与HQL中的问号一一对应
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum,int pageSize,String sql,List<Object> parameters);

	/**
	 * 公共分页查询分页信息（最终版）
	 * @param pageNum 当前页
	 * @param pageSize 每页显示的条数
	 * @param queryHelper  使用工具类得到查询语句
	 * @return
	 */
	PageBean getPageBean(int pageNum,int pageSize,QueryHelper queryHelper);
}
