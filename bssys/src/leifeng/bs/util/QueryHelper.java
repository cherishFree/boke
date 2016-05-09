package leifeng.bs.util;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import leifeng.bs.base.DaoSupport;
import leifeng.bs.domain.PageBean;

/**
 * 用于辅助拼接HQL语句
 * @author leifeng
 *
 */
public class QueryHelper {
	private String fromClause;//FROM 子句
	private String whereClause="";//where 子句
	private String orderByClause="";//OrderBy子句
	
	private List<Object> parameters=new ArrayList<Object>();//参数列表
	/**
	 * 生成From子句
	 */
	public QueryHelper(Class clazz,String allas){
		fromClause="FROM "+clazz.getSimpleName()+" "+allas;
	}
	/**
	 * 拼接where 子句
	 * @param condition
	 * @param param
	 */
	public QueryHelper addCondition(String condition,Object... params){
		if(whereClause.length()==0){
			//拼接
			whereClause=" WHERE "+condition;
		}else{
			whereClause +=" AND " +condition; 
		}
		//参数
		if(params !=null){
			for(Object p:params){
				parameters.add(p);
			}
			
		}
		return this;
	}
	
	/**
	 * 如果第一个参数为true，则拼接Where子句
	 * 
	 * @param append
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(boolean append, String condition, Object... params) {
		if (append) {
			addCondition(condition, params);
		}
		return this;
	}

	
	/**
	 * 拼接OrderBy子句
	 * @param propertyName 参与排序的属性
	 * @param asc   true 表示升序  false 表示降序
	 */
	public QueryHelper addOrderProperty(String propertyName,boolean asc){
		if(orderByClause.length()==0){
			orderByClause=" ORDER BY "+propertyName+(asc ? " ASC":" DESC");
		}else{
			orderByClause+=", "+propertyName+(asc ? " ASC":" DESC");
		}
		return this;
	}
	
	/**
	 * 如果第一个参数为true，则拼接OrderBy子句
	 * 
	 * @param append
	 * @param propertyName
	 * @param asc
	 */
	public QueryHelper addOrderProperty(boolean append, String propertyName, boolean asc) {
		if (append) {
			addOrderProperty(propertyName, asc);
		}
		return this;
	}
	
	/**
	 * 获取生成用于查询数据列表的HQL语句
	 * @return
	 */
	public String getListQueryHql(){
		return fromClause+whereClause+orderByClause;
	}
	
	/**
	 * 获取生成用于查询总记录数的HQL语句
	 * @return
	 */
	public String getCountQueryHql(){
		return "SELECT COUNT(*) "+fromClause+whereClause;
	}
	/**
	 * 获取HQL中的参数值列表
	 * @param parameters
	 */
	public List<Object> getParameters() {
		return parameters;
	}
	
	/**
	 * 查询分页信息，并保存到值栈栈顶
	 * @param service
	 * @param pageNum
	 * @param pageSize
	 */
	public void preparePageBean(DaoSupport<?> service,int pageNum,int pageSize){
		PageBean pageBean=service.getPageBean(pageNum, pageSize,this);
		ActionContext.getContext().getValueStack().push(pageBean);
	}
	

}
