package leifeng.bs.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Collections;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import leifeng.bs.domain.PageBean;
import leifeng.bs.util.QueryHelper;

@Transactional
@SuppressWarnings("unchecked")
public class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private  SessionFactory sessionFactory;
	
	private Class<T> clazz;//这是一个问题
	
	public DaoSupportImpl(){
		//使用反射技术得到T的真实类型
		ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();//获取当前new的对象的泛型父类类型
		this.clazz=(Class<T>)pt.getActualTypeArguments()[0];
		
		System.out.println("clazz--------->"+clazz);
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T entity) {
		getSession().save(entity);
		
	}

	@Override
	public void delete(Long id) {
		Object obj=getById(id);
		if(obj!=null){
			getSession().delete(obj);
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
		
	}

	@Override
	public T getById(Long id) {
		if(id==null){
			return null;
		}{
			return (T)getSession().get(clazz, id);
		}
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if(ids==null || ids.length==0){
			return Collections.EMPTY_LIST;
		}else{
			return getSession().createQuery(
					"FROM "+clazz.getSimpleName()+" WHERE id IN(:ids)")//
					.setParameterList("ids", ids)
					.list();
		}
	}

	
	@Override
	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM "+clazz.getSimpleName())//
				.list();
	}

	/**  公共查询分页信息的列表  */
	@Override
	@Deprecated
	public PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters) {
		System.out.println("----------------->DaoSupportImpl.getPageBean");
		
		//查询本页的数据列表
		Query listQuery=getSession().createQuery(hql);
		if(parameters !=null){
			for(int i=0;i<parameters.size();i++){
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum-1)*pageSize);
		listQuery.setMaxResults(pageSize);
		List list=listQuery.list();
		//查询总数量
		Query countQuery=getSession().createQuery("SELECT COUNT(*) "+hql);
		if(parameters !=null){
			for(int i=0;i<parameters.size();i++){
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		
		Long count=(Long)countQuery.uniqueResult();//执行查询
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}

	/** 公共查询方法最终版  */
	@Override
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
        System.out.println("----------------->DaoSupportImpl.getPageBean");
		
        //参数列表
        List<Object> parameters=queryHelper.getParameters();
        
		//查询本页的数据列表
		Query listQuery=getSession().createQuery(queryHelper.getListQueryHql());//创建查询对象
		if(parameters !=null){
			for(int i=0;i<parameters.size();i++){
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum-1)*pageSize);
		listQuery.setMaxResults(pageSize);
		List list=listQuery.list();
		//查询总数量
		Query countQuery=getSession().createQuery(queryHelper.getCountQueryHql());
		if(parameters !=null){
			for(int i=0;i<parameters.size();i++){
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		
		Long count=(Long)countQuery.uniqueResult();//执行查询
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}

}
